package com.reposicao.reposicaoAulaProjeto.entidades.academia;

import com.reposicao.reposicaoAulaProjeto.dao.academiaRepository.CursoRepository;
import com.reposicao.reposicaoAulaProjeto.dao.academiaRepository.DisciplinaRepository;
import com.reposicao.reposicaoAulaProjeto.dao.academiaRepository.ProfessorRepository;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Disciplina Tester.
 *
 * @author <Authors name>
 * @since <pre>05/22/2019</pre>
 * @version 1.0
 */
@DataJpaTest
@RunWith(SpringRunner.class)
public class DisciplinaTest  {

    @Autowired
    private DisciplinaRepository disciplinaRepository;
    @Autowired
    private CursoRepository cursoRepository;
    @Autowired
    ProfessorRepository professorRepository;
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private Curso curso, curso2;
    private Professor professor, professor2;

    @Before
    public void setUp(){
        this.curso = new Curso();
        this.professor = new Professor();
        this.curso2 = new Curso();
        this.professor2 = new Professor();
        this.curso.setDescricao("Arquitetura");
        this.curso.setSigla("SO33");
        this.curso2.setDescricao("Geografia");
        this.curso2.setSigla("GO33");
        this.cursoRepository.save(curso);
        this.cursoRepository.save(curso2);
        professor.setName("Jorge");
        professor.setSIAPE(1234);
        professor2.setName("Fernando");
        professor2.setSIAPE(12340000);
        this.professorRepository.save(professor);
        this.professorRepository.save(professor2);
    }

    @org.junit.Test
    public void testeSalvaDisciplina(){
        Disciplina disciplina2 = new Disciplina();
        Disciplina disciplina = new Disciplina();
        disciplina.setDescricao("Progamacao Distri");
        disciplina.setSigla("ProgD");
        disciplina.setProfessor(this.professor);
        disciplina.setCurso(this.curso);
        disciplina2.setDescricao("Progamacao DistriFake");
        disciplina2.setSigla("ProgDFake");
        disciplina2.setProfessor(this.professor);
        disciplina2.setCurso(this.curso);
        this.disciplinaRepository.save(disciplina);
        this.disciplinaRepository.save(disciplina2);
        assertThat(disciplina.getId()).isNotNull();
        assertThat(disciplina.getDescricao()).isEqualTo("Progamacao Distri");
        assertThat(disciplina.getSigla()).isEqualTo("ProgD");
        assertThat(disciplina.getProfessor()).isEqualTo(this.professor);
        assertThat(disciplina.getCurso()).isEqualTo(this.curso);
        assertThat(disciplina2.getId()).isNotNull();
        assertThat(disciplina2.getDescricao()).isEqualTo("Progamacao DistriFake");
        assertThat(disciplina2.getSigla()).isEqualTo("ProgDFake");
        assertThat(disciplina2.getProfessor()).isEqualTo(this.professor);
        assertThat(disciplina2.getCurso()).isEqualTo(this.curso);
    }

    @org.junit.Test
    public void testeAlteraDisciplina(){

        Disciplina disciplina = new Disciplina();
        disciplina.setDescricao("Progamacao Distri");
        disciplina.setSigla("ProgD");
        disciplina.setProfessor(this.professor);
        disciplina.setCurso(this.curso);
        this.disciplinaRepository.save(disciplina);
        disciplina.setDescricao("Progamacao Distribuida");
        disciplina.setSigla("ProgDD");
        disciplina.setProfessor(this.professor2);
        disciplina.setCurso(this.curso2);
        this.disciplinaRepository.save(disciplina);
        Disciplina disciplina2 = this.disciplinaRepository.getOne(disciplina.getId());
        assertThat(disciplina.getDescricao()).isEqualTo("Progamacao Distribuida");
        assertThat(disciplina.getSigla()).isEqualTo("ProgDD");
        assertThat(disciplina.getProfessor()).isEqualTo(this.professor2);
        assertThat(disciplina.getCurso()).isEqualTo(this.curso2);
    }

    @Test()
    public void testeExcluiDisciplina(){
        thrown.expect(org.springframework.orm.jpa.JpaObjectRetrievalFailureException.class);
        Disciplina disciplina = new Disciplina();
        disciplina.setDescricao("Progamacao Distri");
        disciplina.setSigla("ProgD");
        disciplina.setProfessor(this.professor);
        disciplina.setCurso(this.curso);
        this.disciplinaRepository.save(disciplina);
        this.disciplinaRepository.delete(disciplina);
        Disciplina disciplina2 = this.disciplinaRepository.getOne(disciplina.getId());

    }
}
