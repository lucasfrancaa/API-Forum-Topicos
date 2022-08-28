package com.campomagico.forum.form;

import com.campomagico.forum.model.CursoModel;
import com.campomagico.forum.model.TopicoModel;
import com.campomagico.forum.repository.CursoRepository;
import com.sun.istack.NotNull;

import javax.validation.constraints.NotEmpty;

public class TopicoForm {

    @NotNull @NotEmpty
    private String titulo;
    @NotNull @NotEmpty
    private String mensagem;
    @NotNull @NotEmpty
    private String nomeCurso;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public TopicoModel converter(CursoRepository cursoRepository) {
        CursoModel cursoModel = cursoRepository.findByNome(nomeCurso);
    
        return new TopicoModel(titulo, mensagem, cursoModel);
    }
}