package br.univille.projetosofanovostalentos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.projetosofanovostalentos.entity.Pessoa;
import br.univille.projetosofanovostalentos.repository.PessoaRepository;
import br.univille.projetosofanovostalentos.service.PessoaService;

@Service
public class PessoaServiceImpl implements PessoaService{

    @Autowired
    private PessoaRepository repositorio;

    @Override
    public List<Pessoa> getAll() {
            
        return repositorio.findAll();
    }

    @Override
    public Pessoa save(Pessoa pessoa) {
        return repositorio.save(pessoa);
    }

    @Override
    public Pessoa findById(long id) {
        var resultado = repositorio.findById(id);
        if (resultado.isPresent()) {
            return resultado.get();
        }
        return new Pessoa();
    }

    @Override
    public void deletar(long id) {
        repositorio.deleteById(id);
    }
    
}
