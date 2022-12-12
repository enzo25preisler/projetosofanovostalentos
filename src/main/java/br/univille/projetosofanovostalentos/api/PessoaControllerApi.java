package br.univille.projetosofanovostalentos.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.univille.projetosofanovostalentos.entity.Pessoa;
import br.univille.projetosofanovostalentos.service.PessoaService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/v1/pessoas")
public class PessoaControllerApi {
    @Autowired
    private PessoaService service;

    @ApiOperation(value = "Retorna todos os dados das Pessoas")
    @GetMapping
    public ResponseEntity<List<Pessoa>> getAll() {
        var listaPessoas = service.getAll();
        return new ResponseEntity<>(listaPessoas, HttpStatus.OK);
    }

    @ApiOperation(value = "Retorna todos os dados da Pessoa de acordo com o ID")
    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> getById(@PathVariable long id) {
        var umaPessoa = service.findById(id);
        if (umaPessoa.getId() == 0) {
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<Pessoa>(umaPessoa, HttpStatus.OK);
    }

    @ApiOperation(value = "Encontra todos os dados da Pessoa de acordo com o nome pesquisado")
    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<Pessoa>> findByNome(@PathVariable String nome) {
        var listaPessoas = service.findByNome(nome);
        return new ResponseEntity<List<Pessoa>>(listaPessoas, HttpStatus.OK);
    }

    @ApiOperation(value = "Encontra todos os dados da Pessoa de acordo com o nome pesquisado")
    @GetMapping("/")
    public ResponseEntity<List<Pessoa>> findByNomeRequestParam(@RequestParam("nome") String nome) {
        var listaPessoas = service.findByNome(nome);
        return new ResponseEntity<List<Pessoa>>(listaPessoas, HttpStatus.OK);
    }
    @ApiOperation(value = "Salva os dados da Pessoa")
    @PostMapping
    public ResponseEntity<Pessoa> save(@RequestBody Pessoa pessoa) {
        if (pessoa.getId() == 0) {
            var novaPessoa = service.save(pessoa);
            return new ResponseEntity<Pessoa>(novaPessoa, HttpStatus.CREATED);
        }
        return ResponseEntity.badRequest().build();
    }

    @ApiOperation(value = "Altera os dados da Pessoa")
    @PutMapping("/{id}")
    public ResponseEntity<Pessoa> update(@PathVariable long id, @RequestBody Pessoa pessoaAlt) {
        var pessoaAntiga = service.findById(id);
        if (pessoaAntiga.getId() == 0) {
            return ResponseEntity.notFound().build();
        }
        pessoaAntiga.setNome(pessoaAlt.getNome());
        pessoaAntiga.setTelefone(pessoaAlt.getTelefone());

        service.save(pessoaAntiga);
        return new ResponseEntity<Pessoa>(pessoaAntiga, HttpStatus.OK);
    }

    @ApiOperation(value = "Deleta todos os dados da Pessoa")
    @DeleteMapping("/{id}")
    public ResponseEntity<Pessoa> delete(@PathVariable long id) {
        var clienteAntigo = service.findById(id);
        if (clienteAntigo.getId() == 0) {
            return ResponseEntity.notFound().build();
        }
        service.deletar(id);
        return new ResponseEntity<Pessoa>(clienteAntigo, HttpStatus.OK);
    }
}
