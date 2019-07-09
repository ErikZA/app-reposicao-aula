package com.reposicao.reposicaoAulaProjeto.dao.academiaRepository;

import com.reposicao.reposicaoAulaProjeto.entidades.academia.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository  extends JpaRepository<Aluno, Long> {

}
