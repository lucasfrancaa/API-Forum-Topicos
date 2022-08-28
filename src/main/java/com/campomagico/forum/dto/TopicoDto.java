package com.campomagico.forum.dto;

import com.campomagico.forum.model.TopicoModel;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class TopicoDto {
    private Long id;
    private String titulo;
    private String mensagem;
    private LocalDateTime dataCriacao;

    public TopicoDto(TopicoModel topicoModel){
        this.id = topicoModel.getId();
        this.titulo = topicoModel.getTitulo();
        this.mensagem = topicoModel.getMensagem();
        this.dataCriacao = topicoModel.getDataCriacao();
    }

    public static Page<TopicoDto> converter(Page<TopicoModel> topicoModels) {
        return topicoModels.map(TopicoDto::new);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public LocalDateTime getData() {
        return dataCriacao;
    }

    public void setData(LocalDate data) {
        this.dataCriacao = LocalDateTime.from(data);
    }
}
