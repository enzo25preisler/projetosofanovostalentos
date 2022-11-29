package br.univille.projetosofanovostalentos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.projetosofanovostalentos.entity.Venda;
import br.univille.projetosofanovostalentos.repository.VendaRepository;
import br.univille.projetosofanovostalentos.service.VendaService;

@Service
public class VendaServiceImpl implements VendaService {
    @Autowired
    private VendaRepository repositorio;

    @Override
    public List<Venda> getAll() {
            
        return repositorio.findAll();
    }

    @Override
    public Venda save(Venda pessoa) {
        return repositorio.save(pessoa);
    }

    @Override
    public Venda findById(long id) {
        var resultado = repositorio.findById(id);
        if (resultado.isPresent()) {
            return resultado.get();
        }
        return new Venda();
    }

    @Override
    public void deletar(long id) {
        repositorio.deleteById(id);
    }
    
}
