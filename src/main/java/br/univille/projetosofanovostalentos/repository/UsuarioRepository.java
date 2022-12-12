package br.univille.projetosofanovostalentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.projetosofanovostalentos.entity.Usuario;

@Repository
public interface UsuarioRepository 
        extends JpaRepository<Usuario,Long> {
    Usuario findByNome(String nome);
}
