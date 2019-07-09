package com.reposicao.reposicaoAulaProjeto.entidades.academia;

import com.reposicao.reposicaoAulaProjeto.dao.academiaRepository.AlunoRepository;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.*;

/**
 * Aluno Tester.
 *
 * @author <Authors name>
 * @since <pre>05/22/2019</pre>
 * @version 1.0
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class AlunoTest{

    @Autowired
    private AlunoRepository alunoRepository;
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testeSalvaAluno(){
        Aluno aluno = new Aluno();
        aluno.setName("Jorge");
        aluno.setMatricula(1234);
        aluno.setCurso("dsf");
        this.alunoRepository.save(aluno);
        assertThat(aluno.getId()).isNotNull();
        assertThat(aluno.getName()).isEqualTo("Jorge");
        assertThat(aluno.getMatricula()).isEqualTo(1234);
    }

    @Test
    public void testeAlteraAluno(){
        Aluno aluno = new Aluno();
        aluno.setName("Jorge");
        aluno.setMatricula(1234);
        this.alunoRepository.save(aluno);
        aluno.setName("Jorge Chavier");
        aluno.setMatricula(123434);
        this.alunoRepository.save(aluno);
        Aluno aluno2 = this.alunoRepository.getOne(aluno.getId());
        assertThat(aluno2.getName()).isEqualTo("Jorge Chavier");
        assertThat(aluno2.getMatricula()).isEqualTo(123434);
    }

    @Test ()
    public void testeExcluiAluno(){
        thrown.expect(org.springframework.orm.jpa.JpaObjectRetrievalFailureException.class);
        Aluno aluno = new Aluno();
        aluno.setName("Jorge");
        aluno.setMatricula(1234);
        this.alunoRepository.save(aluno);
        this.alunoRepository.delete(aluno);
        Aluno aluno2 = this.alunoRepository.getOne(aluno.getId());
    }

}
