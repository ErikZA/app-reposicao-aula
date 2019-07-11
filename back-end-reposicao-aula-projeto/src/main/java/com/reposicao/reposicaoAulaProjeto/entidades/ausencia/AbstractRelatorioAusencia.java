package com.reposicao.reposicaoAulaProjeto.entidades.ausencia;


import com.reposicao.reposicaoAulaProjeto.entidades.academia.Diario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;


@Component
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class AbstractRelatorioAusencia implements Serializable {


    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Column
    protected String dataSaida;

    @Column
    protected String dataRetorno;

    @ManyToOne
    protected Diario diario;

    @Column
    private String motivoComentario;


}
