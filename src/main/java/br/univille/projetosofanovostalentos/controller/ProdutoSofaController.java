package br.univille.projetosofanovostalentos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.projetosofanovostalentos.entity.ProdutoSofa;
import br.univille.projetosofanovostalentos.service.ProdutoSofaService;

@Controller
@RequestMapping("/produtossofa")
public class ProdutoSofaController {
    @Autowired
    private ProdutoSofaService service;

    @GetMapping()
    public ModelAndView index(){
        var listaProdutos = service.getAll();
        return new ModelAndView("produtosofa/index","listaProdutos",listaProdutos);
    }

    @GetMapping("/novo")
    public ModelAndView novo(){
        var produtoSofa = new ProdutoSofa();
        return new ModelAndView("produtosofa/form","produtoSofa",produtoSofa);
    }

    @PostMapping(params = "form")
    public ModelAndView save(ProdutoSofa produtoSofa){
        service.save(produtoSofa);
        return new ModelAndView("redirect:/produtossofa");
    }

    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") long id) {
        var produtoSofa = service.findById(id);
        return new ModelAndView("produtosofa/form","produtoSofa",produtoSofa);
    }
    @GetMapping("deletar/{id}")
    public ModelAndView deletar(@PathVariable("id") long id) {
        service.deletar(id);
        return new ModelAndView("redirect:/produtossofa");
    }
}
