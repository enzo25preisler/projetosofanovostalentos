package br.univille.projetosofanovostalentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.univille.projetosofanovostalentos.entity.Venda;

public interface VendaRepository extends JpaRepository<Venda,Long> {
    
}
