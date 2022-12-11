package br.univille.projetosofanovostalentos.controller;

import java.util.HashMap;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.projetosofanovostalentos.entity.Funcionario;
import br.univille.projetosofanovostalentos.service.FuncionarioService;
import br.univille.projetosofanovostalentos.service.PessoaService;

@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService service;
    @Autowired
    private PessoaService pessoaService;

    @GetMapping()
    public ModelAndView index() {
        var listaFuncionarios = service.getAll();
        return new ModelAndView("funcionario/index", "listaFuncionarios", listaFuncionarios);
    }

    @GetMapping("/novo")
    public ModelAndView novo() {
        var funcionario = new Funcionario();
        var listaPessoas = pessoaService.getAll();
        HashMap<String, Object> dados = new HashMap<>();
        dados.put("funcionario", funcionario);
        dados.put("listaPessoas", listaPessoas);
        return new ModelAndView("funcionario/form", dados);
    }

    @PostMapping(params = "form")
    public ModelAndView save(@Valid Funcionario funcionario, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            var listaPessoas = pessoaService.getAll();
            HashMap<String, Object> dados = new HashMap<>();
            dados.put("funcionario", funcionario);
            dados.put("listaPessoas", listaPessoas);
            return new ModelAndView("funcionario/form", dados);
        }
        service.save(funcionario);
        return new ModelAndView("redirect:/funcionarios");
    }

    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") long id) {
        var funcionario = service.findById(id);
        var listaPessoas = pessoaService.getAll();
        HashMap<String, Object> dados = new HashMap<>();
        dados.put("funcionario", funcionario);
        dados.put("listaPessoas", listaPessoas);
        return new ModelAndView("funcionario/form", dados);
    }

    @GetMapping("deletar/{id}")
    public ModelAndView deletar(@PathVariable("id") long id) {
        service.deletar(id);
        return new ModelAndView("redirect:/funcionarios");
    }
}
