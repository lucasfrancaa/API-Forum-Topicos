package com.campomagico.forum.form;

import javax.validation.constraints.NotEmpty;

import com.campomagico.forum.model.TopicoModel;
import com.campomagico.forum.repository.TopicoRepository;
import com.sun.istack.NotNull;

public class AtualizacaoTopicoForm {
	
	@NotNull @NotEmpty
    private String titulo;
    @NotNull @NotEmpty
    private String mensagem;
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
	
	public TopicoModel atualizar(Long id, TopicoRepository topicoRepository) {
		TopicoModel topicoModel = topicoRepository.getReferenceById(id);
		topicoModel.setTitulo(this.titulo);
		topicoModel.setMensagem(this.mensagem);
		return topicoModel;
	}
}
