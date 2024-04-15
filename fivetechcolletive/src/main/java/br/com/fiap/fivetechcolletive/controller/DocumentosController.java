package br.com.fiap.fivetechcolletive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.fivetechcolletive.model.Documentos;
import br.com.fiap.fivetechcolletive.repository.DocumentosRepository;

@RestController
@RequestMapping("/documentos")
public class DocumentosController {

    @Autowired
    private DocumentosRepository documentosRepository;

    @GetMapping("/{id}")
    public ResponseEntity<Documentos> getDocumentosById(@PathVariable Long id) {
        Documentos documentos = documentosRepository.findById(id).orElse(null);
        if (documentos == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(documentos);
    }

    @PostMapping
    public ResponseEntity<Documentos> createDocumentos(@RequestBody Documentos documentos) {
        Documentos createdDocumentos = documentosRepository.save(documentos);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDocumentos);
    }
}

