package br.com.fiap.fivetechcolletive.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.fivetechcolletive.model.Cadastrar;
import br.com.fiap.fivetechcolletive.repository.CadastrarRepository;

@RestController
@RequestMapping("/cadastros")
public class CadastrarController {

    @Autowired
    private CadastrarRepository cadastrarRepository;

    @GetMapping
    public ResponseEntity<List<Cadastrar>> getAllCadastros() {
        List<Cadastrar> cadastros = cadastrarRepository.findAll();
        return ResponseEntity.ok(cadastros);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cadastrar> getCadastroById(@PathVariable Long id) {
        Cadastrar cadastro = cadastrarRepository.findById(id).orElse(null);
        if (cadastro == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cadastro);
    }

    @PostMapping
    public ResponseEntity<Cadastrar> cadastrar(@RequestBody Cadastrar cadastrar) {
        Cadastrar novoCadastro = cadastrarRepository.save(cadastrar);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoCadastro);
    }
}
