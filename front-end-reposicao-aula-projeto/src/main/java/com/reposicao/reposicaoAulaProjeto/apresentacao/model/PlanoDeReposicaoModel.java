package com.reposicao.reposicaoAulaProjeto.apresentacao.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlanoDeReposicaoModel {
    private long id;
    private int quantidadeDeAulas;
    private long ausencia;
    private String conteudoReposicao;
    private String categoria;
    private double aprovacaoAlunos ;
    private boolean aprovado; 
}
