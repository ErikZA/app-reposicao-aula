package com.reposicao.reposicaoAulaProjeto.servico;


import com.reposicao.reposicaoAulaProjeto.dao.academiaRepository.DiarioRepository;
import com.reposicao.reposicaoAulaProjeto.dao.ausenciaRepository.AusenciaPrevistaRepository;
import com.reposicao.reposicaoAulaProjeto.entidades.ausencia.RelatorioAusenciaPrevista;
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
public class AusenciaService {
    @Autowired
    private AusenciaPrevistaRepository ausenciaPrevistaRepository;
    @Autowired
    private DiarioRepository diarioRepository;

    @GetMapping("/servico/ausencia")
    public ResponseEntity<List<RelatorioAusenciaPrevista>> listar() {
        log.info(ausenciaPrevistaRepository.findAll().toString());
        return ResponseEntity.ok(ausenciaPrevistaRepository.findAll());
    }

    @GetMapping ("/servico/ausencia/{id}")
    public ResponseEntity<RelatorioAusenciaPrevista> listarPorId(@PathVariable int id) {
        Optional<RelatorioAusenciaPrevista> ausenciaEncontrada = ausenciaPrevistaRepository.findAll().stream().filter(p -> p.getId() == id).findAny();
        log.info(ausenciaEncontrada.get()+"<<<<<ISSSO>>>>>");
        return ResponseEntity.of(ausenciaEncontrada);
    }

    @PostMapping("/servico/ausencia")
    public ResponseEntity<RelatorioAusenciaPrevista> criar (@RequestBody RelatorioAusenciaPrevista relatorioAusenciaPrevista) {
        log.info(relatorioAusenciaPrevista.toString()+"<<<<<ISSSO>>>>>");
        ausenciaPrevistaRepository.save(relatorioAusenciaPrevista);
        return ResponseEntity.status(201).body(relatorioAusenciaPrevista);
    }

    @DeleteMapping ("/servico/ausencia/{id}")
    public ResponseEntity excluir (@PathVariable int id) {
        Optional<RelatorioAusenciaPrevista> ausenciaEncontrada = ausenciaPrevistaRepository.findAll().stream().filter(p -> p.getId() == id).findAny();
        if (ausenciaEncontrada.get().getId() == id) {
            ausenciaPrevistaRepository.delete(ausenciaEncontrada.get());
            return ResponseEntity.noContent().build();
        }
        else
            return ResponseEntity.notFound().build();
    }

    @PutMapping ("/servico/ausencia/{id}")
    public ResponseEntity<RelatorioAusenciaPrevista> alterar (@PathVariable int id, @RequestBody RelatorioAusenciaPrevista ausencia){
        Optional<RelatorioAusenciaPrevista> ausenciaEncontrada = ausenciaPrevistaRepository.findAll().stream().filter(p -> p.getId() == id).findAny();
        log.info(ausenciaEncontrada.get()+"<<<<<ISSSO-put>>>>>");
        return ResponseEntity.of(ausenciaEncontrada);
    }
}
