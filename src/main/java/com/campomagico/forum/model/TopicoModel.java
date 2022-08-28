package com.campomagico.forum.model;

import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "topico")
public class TopicoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensagem;
    private LocalDateTime dataCriacao = LocalDateTime.now();
    @Enumerated(EnumType.STRING)
    private StatusTopicoModel status = StatusTopicoModel.NAO_RESPONDIDO;
    
    @ManyToOne
    @JoinColumn(name = "autor_id")
    private UsuarioModel autor;
    
    @ManyToOne
    @JoinColumn(name = "curso_id")
    private CursoModel curso;
    
    @OneToMany(mappedBy = "topico")
    private List<RespostaModel> respostaModels = new ArrayList<>();

    public TopicoModel() {

    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        TopicoModel other = (TopicoModel) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    public TopicoModel(String titulo, String mensagem, CursoModel curso) {
        this.titulo = titulo;
        this.mensagem = mensagem;
        this.curso = curso;
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

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public StatusTopicoModel getStatus() {
        return status;
    }

    public void setStatus(StatusTopicoModel status) {
        this.status = status;
    }

    public UsuarioModel getAutor() {
        return autor;
    }

    public void setAutor(UsuarioModel autor) {
        this.autor = autor;
    }

    public CursoModel getCurso() {
        return curso;
    }

    public void setCurso(CursoModel curso) {
        this.curso = curso;
    }

    public List<RespostaModel> getRespostas() {
        return respostaModels;
    }

    public void setRespostas(List<RespostaModel> respostas) {
        this.respostaModels = respostas;
    }
    
}