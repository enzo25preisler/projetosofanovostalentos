package br.univille.projetosofanovostalentos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import br.univille.projetosofanovostalentos.entity.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa,Long> {
    List<Pessoa> findByNomeIgnoreCaseContaining(@Param("nome") String nome);
}
