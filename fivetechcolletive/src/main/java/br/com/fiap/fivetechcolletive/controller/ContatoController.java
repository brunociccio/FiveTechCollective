package br.com.fiap.fivetechcolletive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.fivetechcolletive.model.Contato;
import br.com.fiap.fivetechcolletive.repository.ContatoRepository;

@RestController
@RequestMapping("/api/contato")
public class ContatoController {

    @Autowired
    private ContatoRepository contatoRepository;

    @GetMapping("/buscarPorEmail/{email}")
    public ResponseEntity<Contato> buscarContatoPorEmail(@PathVariable String email) {
        Contato contato = contatoRepository.findByEmail(email);
        if (contato != null) {
            return ResponseEntity.ok(contato);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/buscarPorCelular/{celular}")
    public ResponseEntity<Contato> buscarContatoPorCelular(@PathVariable String celular) {
        Contato contato = contatoRepository.findByTelefoneCelular(celular);
        if (contato != null) {
            return ResponseEntity.ok(contato);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
