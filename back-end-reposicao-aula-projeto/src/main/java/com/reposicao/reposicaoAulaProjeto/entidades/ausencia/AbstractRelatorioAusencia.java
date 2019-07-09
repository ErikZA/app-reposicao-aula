package com.reposicao.reposicaoAulaProjeto.entidades.ausencia;


import com.reposicao.reposicaoAulaProjeto.entidades.academia.Diario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Component
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class AbstractRelatorioAusencia implements Serializable {


    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Temporal(TemporalType.TIMESTAMP)//timestamp_format = 'dd/mm/yyyy hh24:mi:ss.ff';
    protected Date dataSaida;

    @Temporal(TemporalType.TIMESTAMP)//timestamp_format = 'dd/mm/yyyy hh24:mi:ss.ff';
    protected Date dataRetorno;

    @ManyToOne
    protected Diario diario;


}
