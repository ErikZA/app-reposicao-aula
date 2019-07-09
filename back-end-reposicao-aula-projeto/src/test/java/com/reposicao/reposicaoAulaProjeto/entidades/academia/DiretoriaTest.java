package com.reposicao.reposicaoAulaProjeto.entidades.academia;

import com.reposicao.reposicaoAulaProjeto.dao.academiaRepository.DiretoriaRepository;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Diretoria Tester.
 *
 * @author <Authors name>
 * @since <pre>05/22/2019</pre>
 * @version 1.0
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class DiretoriaTest  {

    @Autowired
    private DiretoriaRepository diretoriaRepository;
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @org.junit.Test
    public void testeSalvaDiretoria(){
        Diretoria diretoria = new Diretoria();
        diretoria.setDescricao("Diretoria de assuntos Gerais");
        diretoria.setSigla("DIGRAD");
        diretoria.setInstituicao("UTFPR");
        this.diretoriaRepository.save(diretoria);
        assertThat(diretoria.getId()).isNotNull();
        assertThat(diretoria.getDescricao()).isEqualTo("Diretoria de assuntos Gerais");
        assertThat(diretoria.getSigla()).isEqualTo("DIGRAD");
        assertThat(diretoria.getInstituicao()).isEqualTo("UTFPR");
        assertThat(diretoria.getResolucaoDeFaltas()).isEqualTo("Compensação");
    }

    @org.junit.Test
    public void testeAlteraDiretoria(){
        Diretoria diretoria = new Diretoria();
        diretoria.setDescricao("Diretoria de assuntos Gerais");
        diretoria.setSigla("DIGRAD");
        diretoria.setInstituicao("UTFPR");
        this.diretoriaRepository.save(diretoria);
        diretoria.setDescricao("Diretoria de assuntos Academicos");
        diretoria.setSigla("DIGRA");
        diretoria.setInstituicao("UTF");
        this.diretoriaRepository.save(diretoria);
        Diretoria diretoria2 = this.diretoriaRepository.getOne(diretoria.getId());
        assertThat(diretoria2.getDescricao()).isEqualTo("Diretoria de assuntos Academicos");
        assertThat(diretoria2.getSigla()).isEqualTo("DIGRA");
        assertThat(diretoria2.getInstituicao()).isEqualTo("UTF");
        assertThat(diretoria2.getResolucaoDeFaltas()).isEqualTo("Multa");
    }

    @Test()
    public void testeExcluiDiretoria(){
        thrown.expect(org.springframework.orm.jpa.JpaObjectRetrievalFailureException.class);
        Diretoria diretoria = new Diretoria();
        diretoria.setDescricao("Diretoria de assuntos Gerais");
        diretoria.setSigla("DIGRAD");
        diretoria.setInstituicao("UTFPR");
        this.diretoriaRepository.save(diretoria);
        this.diretoriaRepository.delete(diretoria);
        Diretoria diretoria2 = this.diretoriaRepository.getOne(diretoria.getId());
    }


}
