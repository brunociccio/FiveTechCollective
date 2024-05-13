package br.com.fiap.fivetechcolletive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.fivetechcolletive.model.Contato;
import br.com.fiap.fivetechcolletive.repository.ContatoRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("contato")
@Slf4j
@CacheConfig(cacheNames = "contatos")
@Tag(name = "contatos")
public class ContatoController {

    @Autowired
    private ContatoRepository contatoRepository;

    @GetMapping("/buscarPorEmail/{email}")
    @Cacheable
    @Operation(
        summary = "Contato",
        description = "Endpoint relacionado ao contato por email"
    )
    public ResponseEntity<Contato> buscarContatoPorEmail(@PathVariable String email) {
        Contato contato = contatoRepository.findByEmail(email);
        if (contato != null) {
            return ResponseEntity.ok(contato);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/buscarPorCelular/{celular}")
    @Cacheable
    @Operation(
        summary = "Contato",
        description = "Endpoint relacionado ao contato por celular"
    )
    public ResponseEntity<Contato> buscarContatoPorCelular(@PathVariable String celular) {
        Contato contato = contatoRepository.findByTelefoneCelular(celular);
        if (contato != null) {
            return ResponseEntity.ok(contato);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
