package br.com.fiap.fivetechcolletive.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Entity
@Data
public class Documentos {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDocumentos;
    
    @NotBlank(message = "O CPF é obrigatório")
    private String cpf;
    
    @NotBlank(message = "O RG é obrigatório")
    private String rg;
}
