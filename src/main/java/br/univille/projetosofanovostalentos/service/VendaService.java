package br.univille.projetosofanovostalentos.service;

import java.util.List;

import br.univille.projetosofanovostalentos.entity.Venda;

public interface VendaService {
    List<Venda> getAll();
    Venda save(Venda venda);
    Venda findById(long id);
    void deletar(long id);
}
