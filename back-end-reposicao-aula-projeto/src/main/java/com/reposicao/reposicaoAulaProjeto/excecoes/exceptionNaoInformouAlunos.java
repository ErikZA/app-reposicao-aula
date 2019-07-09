package com.reposicao.reposicaoAulaProjeto.excecoes;

public class exceptionNaoInformouAlunos extends Exception{
    public exceptionNaoInformouAlunos (String msg) { super("Deve-se informar os alunos antes de criar o plano:" + msg); }
}
