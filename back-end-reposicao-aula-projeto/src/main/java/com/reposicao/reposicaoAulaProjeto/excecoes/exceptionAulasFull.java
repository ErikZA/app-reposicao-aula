package com.reposicao.reposicaoAulaProjeto.excecoes;

public class exceptionAulasFull extends Exception{
    public exceptionAulasFull(int msg) { super("NUMERO MAXIMO DE 6 AULAS POR DIA:" + msg); }
}
