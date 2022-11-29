package br.univille.projetosofanovostalentos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.projetosofanovostalentos.entity.Funcionario;
import br.univille.projetosofanovostalentos.repository.FuncionarioRepository;
import br.univille.projetosofanovostalentos.service.FuncionarioService;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

    @Autowired
    private FuncionarioRepository repository;

    @Override
    public Funcionario save(Funcionario funcionario) {
        return repository.save(funcionario);
    }

    @Override
    public List<Funcionario> getAll() {
        return repository.findAll();
    }
    
    @Override
    public Funcionario findById(long id) {
        var resultado = repository.findById(id);
        if (resultado.isPresent()) {
            return resultado.get();
        }
        return new Funcionario();
    }

    @Override
    public void deletar(long id) {
        repository.deleteById(id);
    }
}
