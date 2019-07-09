package com.reposicao.reposicaoAulaProjeto.entidades.academia;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Component
public class Curso extends AbstractField implements Serializable {

    @Column
    private String periodoReferencia;
    @Column
    private int totalDeAulas;

}
