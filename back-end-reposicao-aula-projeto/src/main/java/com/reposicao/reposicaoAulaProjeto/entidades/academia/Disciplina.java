package com.reposicao.reposicaoAulaProjeto.entidades.academia;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;


@Builder
@Repository
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Component
public class Disciplina extends AbstractField implements Serializable {

    @ManyToOne
    private Curso curso;

    @ManyToOne
    private Professor professor;

    @Temporal(TemporalType.TIMESTAMP)//timestamp_format = 'dd/mm/yyyy hh24:mi:ss.ff';
    private Date inicioPeriodo;

    @Temporal(TemporalType.TIMESTAMP)//timestamp_format = 'dd/mm/yyyy hh24:mi:ss.ff';
    private Date fimPeriodo;
}
