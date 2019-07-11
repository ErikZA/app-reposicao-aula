package com.reposicao.reposicaoAulaProjeto.servico;


import com.reposicao.reposicaoAulaProjeto.dao.reposicaoRepository.PlanoDeReposicaoRepository;
import com.reposicao.reposicaoAulaProjeto.entidades.reposicao.PlanoDeReposicao;
import com.reposicao.reposicaoAulaProjeto.excecoes.exceptionForaCalendario;
import com.reposicao.reposicaoAulaProjeto.excecoes.exceptionPlanoRejeitadoAlunos;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Log
@Service
@RestController
public class PlanoDeReposicaoService {
    @Autowired
    private PlanoDeReposicaoRepository planoDeReposicaoRepository;

    @GetMapping("/servico/plano")
    public ResponseEntity<List<PlanoDeReposicao>> listar() {
        log.info(planoDeReposicaoRepository.findAll().toString());
        return ResponseEntity.ok(planoDeReposicaoRepository.findAll());
    }

    @GetMapping ("/servico/plano/{id}")
    public ResponseEntity<PlanoDeReposicao> listarPorId(@PathVariable int id) {
        Optional<PlanoDeReposicao> planoEncontrado = planoDeReposicaoRepository.findAll().stream().filter(p -> p.getId() == id).findAny();
        log.info(planoEncontrado.get()+"<<<<<ISSSO>>>>>");
        return ResponseEntity.of(planoEncontrado);
    }

    @PostMapping("/servico/plano")
    public ResponseEntity<PlanoDeReposicao> criar (@RequestBody PlanoDeReposicao planoDeReposicao) {
        log.info(planoDeReposicao.toString()+"<<<<<ISSSO>>>>>");
        planoDeReposicaoRepository.save(planoDeReposicao);
        return ResponseEntity.status(201).body(planoDeReposicao);
    }

    @DeleteMapping ("/servico/plano/{id}")
    public ResponseEntity excluir (@PathVariable int id) {
        Optional<PlanoDeReposicao> planoEncontrado = planoDeReposicaoRepository.findAll().stream().filter(p -> p.getId() == id).findAny();
        if (planoEncontrado.get().getId() == id) {
            planoDeReposicaoRepository.delete(planoEncontrado.get());
            return ResponseEntity.noContent().build();
        }
        else
            return ResponseEntity.notFound().build();
    }

    @PutMapping ("/servico/plano/{id}")
    public ResponseEntity<PlanoDeReposicao> alterar (@PathVariable int id, @RequestBody PlanoDeReposicao plano){
        Optional<PlanoDeReposicao> planoEncontrado = planoDeReposicaoRepository.findAll().stream().filter(p -> p.getId() == id).findAny();
        log.info(planoEncontrado.get()+"<<<<<ISSSO-put>>>>>");
        planoEncontrado.ifPresent(p -> {
            try {
                p.setAprovacaoAlunos(plano.getAprovacaoAlunos());
                p.setQuantidadeDeAulas(plano.getQuantidadeDeAulas());
                p.setCategoria(plano.getCategoria());
                p.setConteudoReposicao(plano.getConteudoReposicao());
                p.getAusencia().setDataSaida(plano.getAusencia().getDataSaida());
                p.getAusencia().setDataRetorno(plano.getAusencia().getDataRetorno());
                p.getAusencia().getDiario().setDataAula(plano.getAusencia().getDiario().getDataAula());
                p.getAusencia().setMotivoComentario(plano.getAusencia().getMotivoComentario());
                planoDeReposicaoRepository.save(p);
            } catch (exceptionPlanoRejeitadoAlunos exceptionPlanoRejeitadoAlunos) {
                plano.setConteudoReposicao(exceptionPlanoRejeitadoAlunos.getMessage());
            }
        });
        return ResponseEntity.of(planoEncontrado);
    }
}
