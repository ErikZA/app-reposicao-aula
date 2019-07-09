package com.reposicao.reposicaoAulaProjeto.servico;

import com.reposicao.reposicaoAulaProjeto.entidades.academia.Aluno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import com.reposicao.reposicaoAulaProjeto.dao.academiaRepository.AlunoRepository;
import java.util.List;
import java.util.Optional;
import lombok.extern.java.Log;

@Log
@Service
@RestController
public class AlunoService {


     @Autowired
    private AlunoRepository alunoRepository;

    @GetMapping("/servico/aluno")
    public ResponseEntity<List<Aluno>>listar() {
        return ResponseEntity.ok(alunoRepository.findAll());
    }

    @GetMapping ("/servico/aluno/{id}")
    public ResponseEntity<Aluno> listarPorId(@PathVariable int id) {
        Optional<Aluno> alunoEncontrado = alunoRepository.findAll().stream().filter(p -> p.getId() == id).findAny();
        log.info(alunoEncontrado.get()+"<<<<<ISSSO>>>>>");
        return ResponseEntity.of(alunoEncontrado);
    }

    @PostMapping("/servico/aluno")
    public ResponseEntity<Aluno> criar (@RequestBody Aluno aluno) {
        alunoRepository.save(aluno);
        return ResponseEntity.status(201).body(aluno);
    }

    @DeleteMapping ("/servico/aluno/{id}")
    public ResponseEntity excluir (@PathVariable int id) {
        Optional<Aluno> alunoEncontrado = alunoRepository.findAll().stream().filter(p -> p.getId() == id).findAny();
        if (alunoEncontrado.get().getId() == id) {
            alunoRepository.delete(alunoEncontrado.get());
            return ResponseEntity.noContent().build();
        }
        else
            return ResponseEntity.notFound().build();
    }

    @PutMapping ("/servico/aluno/{id}")
    public ResponseEntity<Aluno> alterar (@PathVariable int id, @RequestBody Aluno aluno) {
        Optional<Aluno> alunoEncontrado = alunoRepository.findAll().stream().filter(p -> p.getId() == id).findAny();
        log.info(alunoEncontrado.get()+"<<<<<ISSSO-put>>>>>");
        alunoEncontrado.ifPresent(p -> {
            p.setName(aluno.getName());
            p.setCurso(aluno.getCurso());
            p.setMatricula(aluno.getMatricula());
            alunoRepository.save(p);
        });
        return ResponseEntity.of(alunoEncontrado);
    }
}
