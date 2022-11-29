package br.univille.projetosofanovostalentos.service;

import java.util.List;

import br.univille.projetosofanovostalentos.entity.Cliente;

public interface ClienteService {
    List<Cliente> getAll();
    Cliente save(Cliente cliente);
    Cliente findById(long id);
    void deletar(long id);
}
