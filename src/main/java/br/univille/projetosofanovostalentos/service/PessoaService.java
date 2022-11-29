package br.univille.projetosofanovostalentos.service;

import java.util.List;

import br.univille.projetosofanovostalentos.entity.Pessoa;

public interface PessoaService {
    List<Pessoa> getAll();
    Pessoa save(Pessoa pessoa);
    Pessoa findById(long id);
    void deletar(long id);
}
