package com.reposicao.reposicaoAulaProjeto.negocio;


import com.reposicao.reposicaoAulaProjeto.dao.academiaRepository.AlunoRepository;
import com.reposicao.reposicaoAulaProjeto.entidades.academia.Aluno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;

    public void salva(Aluno aluno) {
        alunoRepository.save(aluno);
    }

    public void exclui(Aluno aluno) {
        alunoRepository.delete(aluno);
    }

    public void atualiza(Aluno aluno) {
        this.salva(aluno);
    }

    public List<Aluno> listaTodos() {
        return alunoRepository.findAll();
    }
}
