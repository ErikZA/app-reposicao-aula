package com.reposicao.reposicaoAulaProjeto.entidades.academia;


import com.reposicao.reposicaoAulaProjeto.excecoes.exceptionAulasFull;
import com.reposicao.reposicaoAulaProjeto.excecoes.exceptionNaoInformouAlunos;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import javax.persistence.*;
import java.io.Serializable;


@Entity
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Component
public class Diario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne
    private Disciplina disciplina;
    @ManyToOne
    private Aluno aluno;
    @Column
    private int totalAulasDia;
    @Column
    private int TotalFaltaAluno;
    @Column
    private int anoLetivo;
    @Enumerated (EnumType.STRING)
    private Status status;
    @Column
    private String dataAula;
    @Enumerated (EnumType.STRING)
    private DiaSemana diaSemana;

    public void setTotalAulasDia(int totalAulasDia) throws exceptionAulasFull {
        if(totalAulasDia>6){
            throw new exceptionAulasFull(totalAulasDia);
        }
        else {
            this.totalAulasDia = totalAulasDia;
        }
    }

    public void setStatus(Status status) throws exceptionNaoInformouAlunos{
        if(status.equals(status.NAO_APROVADA)){
            throw new exceptionNaoInformouAlunos(status.NAO_APROVADA.toString());
        } else {
            this.status = status;
        }
    }
}
