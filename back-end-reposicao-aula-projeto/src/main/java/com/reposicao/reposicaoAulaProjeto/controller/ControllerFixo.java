package com.reposicao.reposicaoAulaProjeto.controller;


import com.reposicao.reposicaoAulaProjeto.dao.academiaRepository.DiarioRepository;
import com.reposicao.reposicaoAulaProjeto.dao.ausenciaRepository.AusenciaPrevistaRepository;
import com.reposicao.reposicaoAulaProjeto.dao.reposicaoRepository.PlanoDeReposicaoRepository;
import com.reposicao.reposicaoAulaProjeto.entidades.academia.Diario;
import com.reposicao.reposicaoAulaProjeto.entidades.ausencia.RelatorioAusenciaImprevista;
import com.reposicao.reposicaoAulaProjeto.entidades.ausencia.RelatorioAusenciaPrevista;
import com.reposicao.reposicaoAulaProjeto.entidades.reposicao.PlanoDeReposicao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ControllerFixo {
    @Autowired
    private AusenciaPrevistaRepository ausenciaPrevistaRepository;
    @Autowired
    private DiarioRepository diarioRepository;
    @Autowired
    private PlanoDeReposicaoRepository planoDeReposicaoRepository;

    public void fixoIndice(){
      List<RelatorioAusenciaPrevista>  ausenciaPrevistas = ausenciaPrevistaRepository.findAll();
      List<Diario> diario = diarioRepository.findAll();
      List<PlanoDeReposicao> plano = planoDeReposicaoRepository.findAll();

      for(PlanoDeReposicao auxPlano : plano){
          for(RelatorioAusenciaPrevista auxAusencia : ausenciaPrevistas) {
              if (auxPlano.getId() == auxAusencia.getId()){
                  auxPlano.setAusencia(auxAusencia);
                  planoDeReposicaoRepository.save(auxPlano);
              }
              for(Diario auxDiario : diario) {
                  if (auxAusencia.getId() == auxDiario.getId()){
                      auxAusencia.setDiario(auxDiario);
                      ausenciaPrevistaRepository.save(auxAusencia);
              }
              }
              }
          }
      }
}

