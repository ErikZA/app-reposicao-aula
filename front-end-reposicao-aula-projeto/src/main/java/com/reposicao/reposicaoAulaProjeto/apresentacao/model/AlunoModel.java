package com.reposicao.reposicaoAulaProjeto.apresentacao.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AlunoModel {
    private Long id;
    private String name;
    private String curso;
    private int matricula;
}