package br.univille.projetosofanovostalentos.service;

import java.util.List;

import br.univille.projetosofanovostalentos.entity.ProdutoSofa;

public interface ProdutoSofaService {
    List<ProdutoSofa> getAll();
    ProdutoSofa save(ProdutoSofa produtoSofa);
    ProdutoSofa findById(long id);
    void deletar(long id);
}
