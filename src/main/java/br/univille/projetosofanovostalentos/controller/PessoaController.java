package br.univille.projetosofanovostalentos.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.projetosofanovostalentos.entity.Pessoa;
import br.univille.projetosofanovostalentos.service.PessoaService;


@Controller
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService service;

    @GetMapping()
    public ModelAndView index() {
        var listaPessoas = service.getAll();
        return new ModelAndView("pessoa/index","listaPessoas",listaPessoas);
    }
    @GetMapping("/novo")
    public ModelAndView novo() {
        var pessoa = new Pessoa();
        return new ModelAndView("pessoa/form","pessoa",pessoa);
    }
    @PostMapping(params = "form")
    public ModelAndView save(@Valid Pessoa pessoa, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return new ModelAndView("pessoa/form","pessoa",pessoa);
        }
        service.save(pessoa);
        return new ModelAndView("redirect:/pessoas");
    }
    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") long id) {
        var pessoa = service.findById(id);
        return new ModelAndView("pessoa/form","pessoa",pessoa);
    }
    @GetMapping("deletar/{id}")
    public ModelAndView deletar(@PathVariable("id") long id) {
        service.deletar(id);
        return new ModelAndView("redirect:/pessoas");
    }
    
}
