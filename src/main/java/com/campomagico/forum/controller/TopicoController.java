package com.campomagico.forum.controller;

import com.campomagico.forum.dto.TopicoDto;
import com.campomagico.forum.form.AtualizacaoTopicoForm;
import com.campomagico.forum.form.TopicoForm;
import com.campomagico.forum.model.TopicoModel;
import com.campomagico.forum.repository.CursoRepository;
import com.campomagico.forum.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.persistence.GeneratedValue;
import javax.transaction.Transactional;
import javax.validation.Valid;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private CursoRepository cursoRepository;

/*
    @GetMapping
    public List<TopicoDto> listar(){
    List<TopicoModel> topicoModels = topicoRepository.findAll();
        return TopicoDto.converter(topicoModels);
    }
 */

    /*
    http://localhost:8080/topicos?pagina=0&quantidade=3&ordenacao=id
     */

    @GetMapping
    @Cacheable(value = "listaTopicos")
    public Page<TopicoDto> listar(@RequestParam(required = false) String nomeCurso, @PageableDefault(sort = "id", direction = Sort.Direction.ASC, page = 0, size = 10) Pageable paginacao){


        if(nomeCurso == null){
            Page<TopicoModel> topicoModels = topicoRepository.findAll(paginacao);
            return TopicoDto.converter((Page<TopicoModel>) topicoModels);
        }
        else {
            List<TopicoModel> topicoModels = topicoRepository.findByCursoNome(nomeCurso);
            return TopicoDto.converter((Page<TopicoModel>) topicoModels);
        }
    }

    @PostMapping
    @CacheEvict(value = "listaTopicos", allEntries = true)
	public ResponseEntity<TopicoDto> cadastrar(@RequestBody @Valid TopicoForm form, UriComponentsBuilder uriBuilder) {
		TopicoModel topicoModel = form.converter(cursoRepository);
		topicoRepository.save(topicoModel);
		
		URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topicoModel.getId()).toUri();
		return ResponseEntity.created(uri).body(new TopicoDto(topicoModel));
	}

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<TopicoDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoTopicoForm form){

       TopicoModel topicoModel = form.atualizar(id, topicoRepository);
       return ResponseEntity.ok(new TopicoDto(topicoModel)) ;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity apagar(@PathVariable Long id){
        topicoRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
