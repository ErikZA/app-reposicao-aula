package com.reposicao.reposicaoAulaProjeto.dao.reposicaoRepository;

import com.reposicao.reposicaoAulaProjeto.entidades.reposicao.PlanoDeReposicao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PlanoDeReposicaoRepository extends JpaRepository<PlanoDeReposicao, Long> {
}
