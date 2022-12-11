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

import br.univille.projetosofanovostalentos.entity.Cliente;
import br.univille.projetosofanovostalentos.service.ClienteService;
import br.univille.projetosofanovostalentos.service.PessoaService;

@Controller
@RequestMapping("/clientes")
public class ClienteController {
    
    @Autowired
    private ClienteService service;
    @Autowired
    private PessoaService pessoaService;

    @GetMapping()
    public ModelAndView index(){
        var listaClientes = service.getAll();
        return new ModelAndView("cliente/index","listaClientes", listaClientes);
    }

    @GetMapping("/novo")
    public ModelAndView novo(){
        var cliente = new Cliente();
        var listaPessoas = pessoaService.getAll();
        HashMap<String, Object> dados = new HashMap<>();
        dados.put("cliente", cliente);
        dados.put("listaPessoas", listaPessoas);
        return new ModelAndView("cliente/form",dados);
    }

    @PostMapping(params = "form")
    public ModelAndView save(@Valid Cliente cliente, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            var listaPessoas = pessoaService.getAll();
            HashMap<String, Object> dados = new HashMap<>();
            dados.put("cliente", cliente);
            dados.put("listaPessoas", listaPessoas);
            return new ModelAndView("cliente/form",dados);
        }
        service.save(cliente);
        return new ModelAndView("redirect:/clientes");
    }

    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") long id) {
        var cliente = service.findById(id);
        var listaPessoas = pessoaService.getAll();
        HashMap<String, Object> dados = new HashMap<>();
        dados.put("cliente", cliente);
        dados.put("listaPessoas", listaPessoas);
        return new ModelAndView("cliente/form",dados);
    }
    @GetMapping("/deletar/{id}")
    public ModelAndView deletar(@PathVariable("id") long id) {
        service.deletar(id);
        return new ModelAndView("redirect:/clientes");
    }
}
