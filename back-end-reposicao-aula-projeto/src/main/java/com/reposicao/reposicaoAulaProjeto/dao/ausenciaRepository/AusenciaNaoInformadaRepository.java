package com.reposicao.reposicaoAulaProjeto.dao.ausenciaRepository;

import com.reposicao.reposicaoAulaProjeto.entidades.ausencia.RelatorioAusenciaNaoInformada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AusenciaNaoInformadaRepository extends JpaRepository<RelatorioAusenciaNaoInformada, Long> {
}
