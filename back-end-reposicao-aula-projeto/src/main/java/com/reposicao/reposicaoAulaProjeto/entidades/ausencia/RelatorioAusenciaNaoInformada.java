package com.reposicao.reposicaoAulaProjeto.entidades.ausencia;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;

@Builder
@Component
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class RelatorioAusenciaNaoInformada extends AbstractRelatorioAusencia implements Serializable {

    @Column
    private String comentario;
}