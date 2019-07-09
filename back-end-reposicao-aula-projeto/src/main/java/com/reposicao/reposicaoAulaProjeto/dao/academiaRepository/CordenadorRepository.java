package com.reposicao.reposicaoAulaProjeto.dao.academiaRepository;

import com.reposicao.reposicaoAulaProjeto.entidades.academia.Cordenador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CordenadorRepository extends JpaRepository<Cordenador, Long> {
}
