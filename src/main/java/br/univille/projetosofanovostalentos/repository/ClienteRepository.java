package br.univille.projetosofanovostalentos.repository;

// import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.repository.query.Param;

import br.univille.projetosofanovostalentos.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {
    
}
