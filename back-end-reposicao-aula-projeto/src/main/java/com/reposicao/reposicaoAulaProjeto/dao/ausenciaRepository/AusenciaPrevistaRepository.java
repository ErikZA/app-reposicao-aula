package com.reposicao.reposicaoAulaProjeto.dao.ausenciaRepository;

import com.reposicao.reposicaoAulaProjeto.entidades.ausencia.RelatorioAusenciaPrevista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AusenciaPrevistaRepository extends JpaRepository<RelatorioAusenciaPrevista, Long> {
}
