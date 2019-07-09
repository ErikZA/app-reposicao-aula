package com.reposicao.reposicaoAulaProjeto.entidades.ausencia;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;


@Builder
@Component
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class RelatorioAusenciaPrevista extends AbstractRelatorioAusencia implements Serializable {

    @Column
    private String motivo;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataComunicado;

}

