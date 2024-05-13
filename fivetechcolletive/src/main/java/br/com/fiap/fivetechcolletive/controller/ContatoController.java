package br.com.fiap.fivetechcolletive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.fivetechcolletive.model.Contato;
import br.com.fiap.fivetechcolletive.repository.ContatoRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@RestController
@RequestMapping("contato")
@Slf4j
@CacheConfig(cacheNames = "contatos")
@Tag(name = "contatos")
public class ContatoController {

    @Autowired
    private ContatoRepository contatoRepository;

    @GetMapping()
    @Cacheable
    @Operation(
            summary = "Lista de Contatos",
            description = "Lista todos os contatos cadastrados"
    )
    public List<Contato> index() {
        return contatoRepository.findAll();
    }

    // POST
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Contato criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Validação falhou. Verifique o corpo da requisição")
    })
    @CacheEvict(allEntries = true)
    public Contato create(@Valid @RequestBody Contato contato) {
        log.info("Criando contato: {}", contato);
        return contatoRepository.save(contato);
    }

    // GET
    @GetMapping("/{id}")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Contato encontrado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Contato não encontrado")
    })
    public ResponseEntity<Contato> findById(@PathVariable Long id) {
        return contatoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // PUT
    
    @PutMapping("/{id}")
    @CacheEvict(allEntries = true)
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Contato atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Contato não encontrado")
    })
    public Contato update(@PathVariable Long id, @Valid @RequestBody Contato contato) {
        log.info("Atualizando contato {} para {}", id, contato);
        return contatoRepository.findById(id)
                .map(existingContato -> {
                    contato.setIdContato(existingContato.getIdContato());
                    return contatoRepository.save(contato);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Contato não encontrado"));
    }

    // DELETE
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @CacheEvict(allEntries = true)
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Contato apagado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Contato não encontrado")
    })
    public void delete(@PathVariable Long id) {
        log.info("Apagando contato: {}", id);
        contatoRepository.deleteById(id);
    }
}
