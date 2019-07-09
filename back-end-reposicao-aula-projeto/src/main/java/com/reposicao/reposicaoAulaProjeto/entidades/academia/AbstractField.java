package com.reposicao.reposicaoAulaProjeto.entidades.academia;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public abstract class AbstractField implements Serializable {
    @Column(name="field_id")
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;
    @Column
    protected String descricao;
    @Column
    protected String sigla;

}
