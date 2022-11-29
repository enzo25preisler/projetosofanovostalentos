package br.univille.projetosofanovostalentos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.projetosofanovostalentos.entity.Venda;
import br.univille.projetosofanovostalentos.service.VendaService;

@Controller
@RequestMapping("/vendas")
public class VendaController {
    @Autowired
    private VendaService service;

    @GetMapping()
    public ModelAndView index(){
        var listaVendas = service.getAll();
        return new ModelAndView("venda/index","listaVendas",listaVendas);
    }

    @GetMapping("/novo")
    public ModelAndView novo(){
        var venda = new Venda();
        return new ModelAndView("venda/form","venda",venda);
    }

    @PostMapping(params = "form")
    public ModelAndView save(Venda venda){
        service.save(venda);
        return new ModelAndView("redirect:/vendas");
    }
    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") long id) {
        var venda = service.findById(id);
        return new ModelAndView("venda/form","venda",venda);
    }
    @GetMapping("deletar/{id}")
    public ModelAndView deletar(@PathVariable("id") long id) {
        service.deletar(id);
        return new ModelAndView("redirect:/vendas");
    }
}
