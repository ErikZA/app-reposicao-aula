package com.reposicao.reposicaoAulaProjeto.dao.academiaRepository;

import com.reposicao.reposicaoAulaProjeto.entidades.academia.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {
}
