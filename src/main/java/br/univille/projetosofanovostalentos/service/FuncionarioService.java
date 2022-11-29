package br.univille.projetosofanovostalentos.service;

import java.util.List;

import br.univille.projetosofanovostalentos.entity.Funcionario;

public interface FuncionarioService {
    List<Funcionario> getAll();
    Funcionario save(Funcionario funcionario);
    Funcionario findById(long id);
    void deletar(long id);
}
