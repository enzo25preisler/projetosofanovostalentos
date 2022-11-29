package br.univille.projetosofanovostalentos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.projetosofanovostalentos.entity.Cliente;
import br.univille.projetosofanovostalentos.repository.ClienteRepository;
import br.univille.projetosofanovostalentos.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {
    @Autowired
    private ClienteRepository repository;

    @Override
    public List<Cliente> getAll() {
            
        return repository.findAll();
    }

    @Override
    public Cliente save(Cliente cliente) {
        return repository.save(cliente);
    }

    @Override
    public Cliente findById(long id) {
        var resultado = repository.findById(id);
        if (resultado.isPresent()) {
            return resultado.get();
        }
        return new Cliente();
    }

    @Override
    public void deletar(long id) {
        repository.deleteById(id);
    }
}
