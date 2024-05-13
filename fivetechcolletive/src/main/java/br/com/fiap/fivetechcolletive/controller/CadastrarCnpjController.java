package br.com.fiap.fivetechcolletive.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.fiap.fivetechcolletive.model.CadastrarCnpj;
import br.com.fiap.fivetechcolletive.repository.CadastrarCnpjRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("cadastrar-cnpj")
@Slf4j
@CacheConfig(cacheNames = "cadastrarCnpj")
@Tag(name = "cadastrarCnpj")
public class CadastrarCnpjController {

    @Autowired
    private CadastrarCnpjRepository repository;

    @GetMapping()
    @Cacheable
    @Operation(
            summary = "Lista de Cadastros de CNPJ",
            description = "Lista todos os cadastros de CNPJ"
    )
    public List<CadastrarCnpj> index() {
        return repository.findAll();
    }

    // POST
    @PostMapping
    @ResponseStatus(CREATED)
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Cadastro de CNPJ criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Validação falhou. Verifique o corpo da requisição")
    })
    @CacheEvict(allEntries = true)
    public CadastrarCnpj create(@Valid @RequestBody CadastrarCnpj cadastrarCnpj) {
        log.info("Criando cadastro de CNPJ: {}", cadastrarCnpj);
        return repository.save(cadastrarCnpj);
    }

    // GET by id
    @GetMapping("/{id}")
    @Cacheable
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Cadastro de CNPJ encontrado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Cadastro de CNPJ não encontrado")
    })
    public ResponseEntity<CadastrarCnpj> findById(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

// PUT
@PutMapping("/{id}")
@CacheEvict(allEntries = true)
@ApiResponses({
        @ApiResponse(responseCode = "200", description = "Cadastro de CNPJ atualizado com sucesso"),
        @ApiResponse(responseCode = "404", description = "Cadastro de CNPJ não encontrado")
})
public ResponseEntity<CadastrarCnpj> update(@PathVariable Long id, @Valid @RequestBody CadastrarCnpj cadastrarCnpj) {
    log.info("Atualizando cadastro de CNPJ {} para {}", id, cadastrarCnpj);
    return repository.findById(id)
            .map(existingCadastrarCnpj -> {
                existingCadastrarCnpj.setCnpj(cadastrarCnpj.getCnpj());
                existingCadastrarCnpj.setInscricaoEstadual(cadastrarCnpj.getInscricaoEstadual());
                existingCadastrarCnpj.setRazaoSocial(cadastrarCnpj.getRazaoSocial());
                existingCadastrarCnpj.setPorteDaEmpresa(cadastrarCnpj.getPorteDaEmpresa());
                existingCadastrarCnpj.setDataAberturaEmpresa(cadastrarCnpj.getDataAberturaEmpresa());
                existingCadastrarCnpj.setQtdFuncionarios(cadastrarCnpj.getQtdFuncionarios());
                return ResponseEntity.ok(repository.save(existingCadastrarCnpj));
            })
            .orElse(ResponseEntity.notFound().build());
}

    // DELETE
    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    @CacheEvict(allEntries = true)
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Cadastro de CNPJ apagado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Cadastro de CNPJ não encontrado")
    })
    public void delete(@PathVariable Long id) {
        log.info("Apagando cadastro de CNPJ: {}", id);
        repository.deleteById(id);
    }
}
