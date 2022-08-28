package com.campomagico.forum.repository;

import com.campomagico.forum.model.TopicoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TopicoRepository extends JpaRepository<TopicoModel, Long> {
    List<TopicoModel> findByCursoNome(String nomeCurso);
}
