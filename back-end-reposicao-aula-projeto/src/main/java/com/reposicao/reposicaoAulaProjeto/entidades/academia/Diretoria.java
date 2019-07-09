package com.reposicao.reposicaoAulaProjeto.entidades.academia;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Component
public class Diretoria extends AbstractField implements Serializable {

    @Column
    private String instituicao;
    @ElementCollection
    private List<String> resolucaoDeFaltas;


}
