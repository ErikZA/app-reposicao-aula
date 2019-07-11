package com.reposicao.reposicaoAulaProjeto.apresentacao.control;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.reposicao.reposicaoAulaProjeto.apresentacao.model.DiarioModel;
import com.reposicao.reposicaoAulaProjeto.apresentacao.model.PlanoDeReposicaoModel;
import com.reposicao.reposicaoAulaProjeto.apresentacao.model.RelatorioAusenciaModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PlanoDeReposicaoController {


    @GetMapping("/plano")
    public String inicial(Model data) throws JsonSyntaxException, UnirestException {

        PlanoDeReposicaoModel arrayPlano[] = new Gson()
                .fromJson(
                        Unirest
                                .get("http://localhost:8081/servico/plano")
                                .asJson()
                                .getBody()
                                .toString(),
                        PlanoDeReposicaoModel[].class
                );
        data.addAttribute("planos", arrayPlano);

        RelatorioAusenciaModel reposicaoModels[] = new Gson()
                .fromJson(
                        Unirest
                                .get("http://localhost:8081/servico/ausencia")
                                .asJson()
                                .getBody()
                                .toString(),
                        RelatorioAusenciaModel[].class
                );
        data.addAttribute("ausencias", reposicaoModels);

        DiarioModel diarioModel[] = new Gson()
                .fromJson(
                        Unirest
                                .get("http://localhost:8081/servico/diario")
                                .asJson()
                                .getBody()
                                .toString(),
                        DiarioModel[].class
                );
        data.addAttribute("diarios", diarioModel);

        return "plano-de-reposicao-view";
    }

    @PostMapping("/plano/criar")
    public String criar(PlanoDeReposicaoModel planoDeReposicaoModel, DiarioModel diarioModel, RelatorioAusenciaModel relatorioAusenciaModel) throws UnirestException {

        System.out.println(planoDeReposicaoModel+"<<><><><><>"+diarioModel+"<><><>>>"+   relatorioAusenciaModel);

        Unirest.post("http://localhost:8081/servico/diario")
                .header("Content-type", "application/json")
                .header("accept", "application/json")
                .body(new Gson().toJson(diarioModel, DiarioModel.class))
                .asJson();

        Unirest.post("http://localhost:8081/servico/ausencia")
                .header("Content-type", "application/json")
                .header("accept", "application/json")
                .body(new Gson().toJson(relatorioAusenciaModel, RelatorioAusenciaModel.class))
                .asJson();

        Unirest.post("http://localhost:8081/servico/plano")
                .header("Content-type", "application/json")
                .header("accept", "application/json")
                .body(new Gson().toJson(planoDeReposicaoModel, PlanoDeReposicaoModel.class))
                .asJson();

        return "redirect:/plano";
    }

    @GetMapping ("/plano/excluir")
    public String excluir (@RequestParam int id) throws UnirestException {

        Unirest
                .delete("http://localhost:8081/servico/plano/{id}")
                .routeParam("id", String.valueOf(id))
                .asJson();

        return "redirect:/plano";
    }

    @GetMapping ("/plano/prepara-alterar")
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

    @PostMapping ("/plano/alterar")
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
