package com.reposicao.reposicaoAulaProjeto.apresentacao.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DiarioModel {
    private long id;
    private String disciplina;
    private AlunoModel alunoModel;
    private int totalAulasDia;
    private int totalFaltaAluno;
    private int anoLetivo;
    private String status;
    private String dataAula;
    private String diaSemana;
}
