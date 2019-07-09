package com.reposicao.reposicaoAulaProjeto.entidades.academia;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Component
public class ChefeDeDepartamento extends AbstractPessoa  implements Serializable {

    @ManyToOne
    private Diretoria diretoria;
    @OneToOne
    private Cordenador cordenador;

}
