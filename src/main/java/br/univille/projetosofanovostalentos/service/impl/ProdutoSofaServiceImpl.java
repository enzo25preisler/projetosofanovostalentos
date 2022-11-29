package br.univille.projetosofanovostalentos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.projetosofanovostalentos.entity.ProdutoSofa;
import br.univille.projetosofanovostalentos.repository.ProdutoSofaRepository;
import br.univille.projetosofanovostalentos.service.ProdutoSofaService;

@Service
public class ProdutoSofaServiceImpl implements ProdutoSofaService {
    @Autowired
    private ProdutoSofaRepository repositorio;

    @Override
    public List<ProdutoSofa> getAll() {
            
        return repositorio.findAll();
    }

    @Override
    public ProdutoSofa save(ProdutoSofa produtoSofa) {
        return repositorio.save(produtoSofa);
    }

    @Override
    public ProdutoSofa findById(long id) {
        var resultado = repositorio.findById(id);
        if (resultado.isPresent()) {
            return resultado.get();
        }
        return new ProdutoSofa();
    }

    @Override
    public void deletar(long id) {
        repositorio.deleteById(id);
    }
}
