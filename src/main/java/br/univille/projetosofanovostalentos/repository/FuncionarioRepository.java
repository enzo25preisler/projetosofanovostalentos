package br.univille.projetosofanovostalentos.repository;

// import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.repository.query.Param;

import br.univille.projetosofanovostalentos.entity.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario,Long> {
    
}
