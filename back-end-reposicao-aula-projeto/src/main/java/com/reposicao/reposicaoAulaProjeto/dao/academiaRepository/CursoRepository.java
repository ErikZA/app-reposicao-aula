package com.reposicao.reposicaoAulaProjeto.dao.academiaRepository;

import com.reposicao.reposicaoAulaProjeto.entidades.academia.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
}
