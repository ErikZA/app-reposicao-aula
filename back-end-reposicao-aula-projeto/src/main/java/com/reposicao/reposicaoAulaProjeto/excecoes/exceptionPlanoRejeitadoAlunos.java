package com.reposicao.reposicaoAulaProjeto.excecoes;

public class exceptionPlanoRejeitadoAlunos extends Exception {
    public exceptionPlanoRejeitadoAlunos(Double msg) { super("Alunos rejeitaram o plano:" + msg); }
}
