package com.reposicao.reposicaoAulaProjeto.dao.academiaRepository;

import com.reposicao.reposicaoAulaProjeto.entidades.academia.ChefeDeDepartamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ChefeDeDepartamentoRepository extends JpaRepository<ChefeDeDepartamento, Long> {
}
