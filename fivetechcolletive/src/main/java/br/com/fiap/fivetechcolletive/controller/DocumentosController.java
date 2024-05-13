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

import br.com.fiap.fivetechcolletive.model.Documentos;
import br.com.fiap.fivetechcolletive.repository.DocumentosRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/documentos")
@Slf4j
@CacheConfig(cacheNames = "documentos")
@Tag(name = "documentos")
public class DocumentosController {

    @Autowired
    DocumentosRepository repository;

    @GetMapping()
    @Cacheable
    @Operation(
            summary = "Lista de Documentos",
            description = "Lista todos os documentos cadastrados"
    )
    public List<Documentos> index() {
        return repository.findAll();
    }

    // POST
    @PostMapping
    @ResponseStatus(CREATED)
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Documentos criados com sucesso"),
            @ApiResponse(responseCode = "400", description = "Validação falhou. Verifique o corpo da requisição")
    })
    @CacheEvict(allEntries = true)
    public Documentos create(@Valid @RequestBody Documentos documentos) {
        log.info("Criando documentos: {}", documentos);
        return repository.save(documentos);
    }

    // GET
    @GetMapping("{id}")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Documentos encontrados com sucesso"),
            @ApiResponse(responseCode = "404", description = "Documentos não encontrados")
    })
    public ResponseEntity<Documentos> show(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // PUT
    @PutMapping("{id}")
    @CacheEvict(allEntries = true)
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Documentos atualizados com sucesso"),
            @ApiResponse(responseCode = "404", description = "Documentos não encontrados")
    })
    public Documentos update(@PathVariable Long id, @Valid @RequestBody Documentos documentos) {
        log.info("Atualizando documentos {} para {}", id, documentos);
        return repository.findById(id)
                .map(existingDocumentos -> {
                    documentos.setIdDocumentos(existingDocumentos.getIdDocumentos());
                    return repository.save(documentos);
                })
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Documentos não encontrados"));
    }

    // DELETE
    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    @CacheEvict(allEntries = true)
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Documentos apagados com sucesso"),
            @ApiResponse(responseCode = "404", description = "Documentos não encontrados")
    })
    public void destroy(@PathVariable Long id) {
        log.info("Apagando documentos: {}", id);
        repository.deleteById(id);
    }
}

