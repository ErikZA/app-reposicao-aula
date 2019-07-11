package com.reposicao.reposicaoAulaProjeto.apresentacao.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RelatorioAusenciaModel {
    private Long id;
    private String dataSaida;
    private String dataRetorno;
    private long diario;
    private String motivoComentario;
    private String dataComunicado;
}
