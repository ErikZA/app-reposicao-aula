package com.reposicao.reposicaoAulaProjeto.apresentacao.control;


import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.reposicao.reposicaoAulaProjeto.apresentacao.model.PlanoDeReposicaoModel;
import com.reposicao.reposicaoAulaProjeto.apresentacao.model.RelatorioAusenciaModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RelatorioAusenciaController {

    @GetMapping ("/ausencia/excluir")
    public String excluir (@RequestParam int id) throws UnirestException {

        Unirest
                .delete("http://localhost:8081/servico/plano/{id}")
                .routeParam("id", String.valueOf(id))
                .asJson();

        return "redirect:/plano";
    }

    @GetMapping ("/ausencia/prepara-alterar")
    public String preparaAlterar (@RequestParam int id, Model data) throws JsonSyntaxException, UnirestException {

        PlanoDeReposicaoModel planoDeReposicaoModel
                = new Gson()
                .fromJson(
                        Unirest
                                .get("http://localhost:8081/servico/plano/{id}")
                                .routeParam("id", String.valueOf(id))
                                .asJson()
                                .getBody()
                                .toString(),
                        PlanoDeReposicaoModel.class
                );

        data.addAttribute("planoAtual", planoDeReposicaoModel);

        PlanoDeReposicaoModel planoDeReposicaoModels[] = new Gson()
                .fromJson(
                        Unirest
                                .get("http://localhost:8081/servico/plano")
                                .asJson()
                                .getBody()
                                .toString(),
                        PlanoDeReposicaoModel[].class
                );

        data.addAttribute("planos", planoDeReposicaoModels);

        return "plano-de-reposicao-view";
    }

    @PostMapping ("/ausencia/alterar")
    public String alterar (PlanoDeReposicaoModel planoDeReposicaoModel) throws UnirestException {

        Unirest
                .put("http://localhost:8081/servico/plano/{id}")
                .routeParam("id", String.valueOf(planoDeReposicaoModel.getId()))
                .header("Content-type", "application/json")
                .header("accept", "application/json")
                .body(new Gson().toJson(planoDeReposicaoModel, PlanoDeReposicaoModel.class))
                .asJson();

        return "redirect:/plano";
    }
}
