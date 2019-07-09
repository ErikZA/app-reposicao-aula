package com.reposicao.reposicaoAulaProjeto.dao.ausenciaRepository;

import com.reposicao.reposicaoAulaProjeto.entidades.ausencia.RelatorioAusenciaImprevista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AusenciaImprevistaRepository  extends JpaRepository<RelatorioAusenciaImprevista, Long> {
}
