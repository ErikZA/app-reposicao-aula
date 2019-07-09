package com.reposicao.reposicaoAulaProjeto.entidades.academia;

import com.reposicao.reposicaoAulaProjeto.entidades.ausencia.AbstractRelatorioAusencia;
import com.reposicao.reposicaoAulaProjeto.entidades.reposicao.PlanoDeReposicao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Component
public class Cordenador extends AbstractPessoa implements Serializable {


    @OneToOne
    private Curso curso;
    @ManyToOne
    private PlanoDeReposicao planoDeReposicao;

    //ausencias não informada ou não registradas
    @ElementCollection
    private List<AbstractRelatorioAusencia> ausenciasPendentes;

    @Column
    private double percentualDeAusencia;

    @Column
    private String formaReposicao;

    @Column
    private String msgAoDocente;

}
