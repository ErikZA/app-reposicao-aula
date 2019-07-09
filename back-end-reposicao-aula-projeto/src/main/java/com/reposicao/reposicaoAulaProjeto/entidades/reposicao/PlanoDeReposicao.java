package com.reposicao.reposicaoAulaProjeto.entidades.reposicao;

import com.reposicao.reposicaoAulaProjeto.entidades.academia.Aluno;
import com.reposicao.reposicaoAulaProjeto.entidades.ausencia.AbstractRelatorioAusencia;
import com.reposicao.reposicaoAulaProjeto.excecoes.exceptionPlanoRejeitadoAlunos;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Builder
@Entity
@Data
@NoArgsConstructor
@Component
@AllArgsConstructor
public class PlanoDeReposicao implements Serializable {

    @Column
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private int quantidadeDeAulas;
    @OneToOne
    private AbstractRelatorioAusencia ausencia;
    @Column
    private String conteudoReposicao;
    //presencial ou não
    @Enumerated (EnumType.STRING)
    private Categoria categoria;
    //alunos que aprovarão o plano
    @Column
    private double aprovacaoAlunos ;
   //Aprovado pelo cordenador
    @Column(nullable = true)
    private boolean aprovado;

    public void setAprovacaoAlunos(double aprovacaoAlunos) throws exceptionPlanoRejeitadoAlunos {
        if(aprovacaoAlunos<75) {
            throw new exceptionPlanoRejeitadoAlunos(aprovacaoAlunos);
        } else {
            this.aprovacaoAlunos = aprovacaoAlunos;
        }
    }

}
