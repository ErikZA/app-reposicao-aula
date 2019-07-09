package com.reposicao.reposicaoAulaProjeto.entidades.academia;

import com.reposicao.reposicaoAulaProjeto.dao.academiaRepository.CursoRepository;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Curso Tester.
 *
 * @author <Authors name>
 * @since <pre>05/22/2019</pre>
 * @version 1.0
 */

@RunWith(SpringRunner.class)
@DataJpaTest
public class CursoTest {


    @Autowired
    private CursoRepository cursoRepository;
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @org.junit.Test
    public void testeSalvaCurso(){
        Curso curso = new Curso();
        curso.setDescricao("Arquitetura");
        curso.setSigla("SO33");
        this.cursoRepository.save(curso);
        assertThat(curso.getId()).isNotNull();
        assertThat(curso.getDescricao()).isEqualTo("Arquitetura");
        assertThat(curso.getSigla()).isEqualTo("SO33");
    }

    @org.junit.Test
    public void testeAlteraCurso(){
        Curso curso = new Curso();
        curso.setDescricao("Arquitetura");
        curso.setSigla("ED11");
        this.cursoRepository.save(curso);
        curso.setDescricao("Entidade Relacionamento");
        curso.setSigla("ED22");
        this.cursoRepository.save(curso);
        Curso curso2 = this.cursoRepository.getOne(curso.getId());
        assertThat(curso2.getDescricao()).isEqualTo("Entidade Relacionamento");
        assertThat(curso2.getSigla()).isEqualTo("ED22");
    }

    @Test()
    public void testeExcluiCurso(){
        thrown.expect(org.springframework.orm.jpa.JpaObjectRetrievalFailureException.class);
        Curso curso = new Curso();
        curso.setDescricao("arquitetura");
        curso.setSigla("Atr");
        this.cursoRepository.save(curso);
        this.cursoRepository.delete(curso);
        Curso professor2 = this.cursoRepository.getOne(curso.getId());
    }

}
