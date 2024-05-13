package br.com.fiap.fivetechcolletive.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.NO_CONTENT;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.fivetechcolletive.model.Endereco;
import br.com.fiap.fivetechcolletive.repository.EnderecoRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("endereco")
@Slf4j
@CacheConfig(cacheNames = "enderecos")
@Tag(name = "enderecos")
public class EnderecoController {

    @Autowired
    EnderecoRepository repository;

    @GetMapping()
    @Cacheable
    @Operation(
            summary = "Lista de Endereços",
            description = "Lista todos os endereços cadastrados"
    )
    public List<Endereco> index() {
        return repository.findAll();
    }

    // POST
    @PostMapping
    @ResponseStatus(CREATED)
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Endereço criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Validação falhou. Verifique o corpo da requisição")
    })
    @CacheEvict(allEntries = true)
    public Endereco create(@Valid @RequestBody Endereco endereco) {
        log.info("Criando endereço: {}", endereco);
        return repository.save(endereco);
    }

    // GET
    @GetMapping("{id}")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Endereço encontrado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Endereço não encontrado")
    })
    public ResponseEntity<Endereco> show(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // PUT
    @PutMapping("{id}")
    @CacheEvict(allEntries = true)
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Endereço atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Endereço não encontrado")
    })
    public Endereco update(@PathVariable Long id, @Valid @RequestBody Endereco endereco) {
        log.info("Atualizando endereço {} para {}", id, endereco);
        return repository.findById(id)
                .map(existingEndereco -> {
                    endereco.setIdEndereco(existingEndereco.getIdEndereco());
                    return repository.save(endereco);
                })
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Endereço não encontrado"));
    }

    // DELETE
    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    @CacheEvict(allEntries = true)
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Endereço apagado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Endereço não encontrado")
    })
    public void destroy(@PathVariable Long id) {
        log.info("Apagando endereço: {}", id);
        repository.deleteById(id);
    }
}

