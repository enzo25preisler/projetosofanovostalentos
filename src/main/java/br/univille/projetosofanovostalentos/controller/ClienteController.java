package br.univille.projetosofanovostalentos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.projetosofanovostalentos.entity.Cliente;
import br.univille.projetosofanovostalentos.service.ClienteService;

@Controller
@RequestMapping("/clientes")
public class ClienteController {
    
    @Autowired
    private ClienteService service;

    @GetMapping()
    public ModelAndView index(){
        var listaClientes = service.getAll();
        return new ModelAndView("cliente/index","listaClientes",listaClientes);
    }

    @GetMapping("/novo")
    public ModelAndView novo(){
        var cliente = new Cliente();
        return new ModelAndView("cliente/form","cliente",cliente);
    }

    @PostMapping(params = "form")
    public ModelAndView save(Cliente cliente){
        service.save(cliente);
        return new ModelAndView("redirect:/clientes");
    }

    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") long id) {
        var cliente = service.findById(id);
        return new ModelAndView("cliente/form","cliente",cliente);
    }
    @GetMapping("deletar/{id}")
    public ModelAndView deletar(@PathVariable("id") long id) {
        service.deletar(id);
        return new ModelAndView("redirect:/clientes");
    }
}
