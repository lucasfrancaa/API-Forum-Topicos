package com.campomagico.forum.repository;

import com.campomagico.forum.model.CursoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<CursoModel, Long> {
    CursoModel findByNome(String nomeCurso);
}
