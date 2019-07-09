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
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Professor extends AbstractPessoa implements Serializable {

    @Column
    private int SIAPE;
    @Column
    private int cargaHorariaTotal;
    @Column
    private int faltas;

    void chamado(){

    }

}


