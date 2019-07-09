package com.reposicao.reposicaoAulaProjeto.excecoes;

public class exceptionForaCalendario extends Exception{
    public exceptionForaCalendario(String msg) { super("Impossivel agendar, fora do calendario academico:" + msg); }
}
