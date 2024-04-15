package br.com.fiap.fivetechcolletive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.fivetechcolletive.model.CadastrarCnpj;
import br.com.fiap.fivetechcolletive.repository.CadastrarCnpjRepository;

@RestController
@RequestMapping("/api/cadastrarCnpj")
public class CadastrarCnpjController {

    @Autowired
    private CadastrarCnpjRepository cadastrarCnpjRepository;

    @GetMapping("/{id}")
    public ResponseEntity<CadastrarCnpj> buscarCadastrarCnpjPorId(@PathVariable int id) {
        CadastrarCnpj cadastrarCnpj = cadastrarCnpjRepository.findById(id);
        if (cadastrarCnpj != null) {
            return ResponseEntity.ok(cadastrarCnpj);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}