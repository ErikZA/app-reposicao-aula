package com.reposicao.reposicaoAulaProjeto.servico;

import com.reposicao.reposicaoAulaProjeto.controller.ControllerFixo;
import com.reposicao.reposicaoAulaProjeto.dao.academiaRepository.DiarioRepository;
import com.reposicao.reposicaoAulaProjeto.entidades.academia.Diario;
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
public class DiarioService {
    @Autowired
    private DiarioRepository diarioRepository;
    @Autowired
    private ControllerFixo controllerFixo;

    @GetMapping("/servico/diario")
    public ResponseEntity<List<Diario>> listar() {
        log.info(diarioRepository.findAll().toString());
        return ResponseEntity.ok(diarioRepository.findAll());
    }

    @GetMapping ("/servico/diario/{id}")
    public ResponseEntity<Diario> listarPorId(@PathVariable int id) {
        Optional<Diario> diarioEncontrado = diarioRepository.findAll().stream().filter(p -> p.getId() == id).findAny();
        log.info(diarioEncontrado.get()+"<<<<<ISSSO>>>>>");
        return ResponseEntity.of(diarioEncontrado);
    }

    @PostMapping("/servico/diario")
    public ResponseEntity<Diario> criar (@RequestBody Diario diario) {
        log.info(diario.toString()+"<<<<<ISSSO>>>>>");
        diarioRepository.save(diario);
        controllerFixo.fixoIndice();
        return ResponseEntity.status(201).body(diario);
    }

    @DeleteMapping ("/servico/diario/{id}")
    public ResponseEntity excluir (@PathVariable int id) {
        Optional<Diario> diarioEncontrado = diarioRepository.findAll().stream().filter(p -> p.getId() == id).findAny();
        if (diarioEncontrado.get().getId() == id) {
            diarioRepository.delete(diarioEncontrado.get());
            return ResponseEntity.noContent().build();
        }
        else
            return ResponseEntity.notFound().build();
    }

    @PutMapping ("/servico/diario/{id}")
    public ResponseEntity<Diario> alterar (@PathVariable int id, @RequestBody Diario diario){
        Optional<Diario> diarioEncontrado = diarioRepository.findAll().stream().filter(p -> p.getId() == id).findAny();
        log.info(diarioEncontrado.get()+"<<<<<ISSSO-put>>>>>");
        return ResponseEntity.of(diarioEncontrado);
    }
}
