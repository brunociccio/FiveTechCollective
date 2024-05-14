package br.com.fiap.fivetechcolletive.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.NO_CONTENT;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.fivetechcolletive.model.Cadastro;
import br.com.fiap.fivetechcolletive.repository.CadastroRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("cadastro")
@Slf4j
@CacheConfig(cacheNames = "cadastros")
@Tag(name = "cadastros")
public class CadastroController {

    @Autowired
    CadastroRepository repository;

    @Autowired
    PagedResourcesAssembler<Cadastro> pageAssembler;


    @GetMapping()
    @Cacheable
    @Operation(
        summary = "Lista de Cadastros",
        description = "Endpoints relacionados a cadastro"
    )
    public List<Cadastro> index() {
        return repository.findAll();
    }

    // POST
    @PostMapping
    @ResponseStatus(CREATED)
    @ApiResponses({
        @ApiResponse(responseCode = "201", description = "Cadastro criado com sucesso"),
        @ApiResponse(responseCode = "400", description = "Validação falhou. Verifique o corpo da requisição")
    })
    @CacheEvict(allEntries = true)
    public Cadastro create(@Valid @RequestBody Cadastro cadastro) {
        log.info("Criando cadastro: {}", cadastro);
        return repository.save(cadastro);
    }

    // GET
    @GetMapping("{id}")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Cadastro encontrado com sucesso"),
        @ApiResponse(responseCode = "404", description = "Cadastro não encontrado")
    })
    public ResponseEntity<Cadastro> show(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // PUT
    @PutMapping("{id}")
    @CacheEvict(allEntries = true)
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Cadastro atualizado com sucesso"),
        @ApiResponse(responseCode = "404", description = "Cadastro não encontrado")
    })
    public Cadastro update(@PathVariable Long id, @Valid @RequestBody Cadastro cadastro) {
        log.info("Atualizando cadastro {} para {}", id, cadastro);
        return repository.findById(id)
                .map(existingCadastro -> {
                    cadastro.setIdCadastrar(existingCadastro.getIdCadastrar());
                    return repository.save(cadastro);
                })
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Cadastro não encontrado"));
    }

    // DELETE
    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    @CacheEvict(allEntries = true)
    @ApiResponses({
        @ApiResponse(responseCode = "204", description = "Cadastro apagado com sucesso"),
        @ApiResponse(responseCode = "404", description = "Cadastro não encontrado")
    })
    public void destroy(@PathVariable Long id) {
        log.info("Apagando cadastro: {}", id);
        repository.deleteById(id);
    }
    
}
