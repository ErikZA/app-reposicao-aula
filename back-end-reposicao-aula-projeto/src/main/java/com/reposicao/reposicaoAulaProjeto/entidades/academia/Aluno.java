package com.reposicao.reposicaoAulaProjeto.entidades.academia;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;

@Data
@Entity
@Component
public class Aluno extends AbstractPessoa implements Serializable {

    @Column
    private int matricula;

    @Column
    private String curso;

      public Aluno(Long id, String name, int matricula, String curso) {
        this.setId(id);
        this.setName(name);
        this.setMatricula(matricula);
        this.setCurso(curso);
    }

    public Aluno() {
        super();
}

}