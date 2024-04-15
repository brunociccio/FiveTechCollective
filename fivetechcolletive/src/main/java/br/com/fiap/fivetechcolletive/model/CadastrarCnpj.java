package br.com.fiap.fivetechcolletive.model;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.Data;


@Entity
@Data
public class CadastrarCnpj {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCadastrarCnpj;
    
    @NotBlank(message = "O CNPJ é obrigatório")
    private String cnpj;
    
    @NotBlank(message = "A inscrição estadual é obrigatória")
    private String inscricaoEstadual;
    
    @NotBlank(message = "A razão social é obrigatória")
    private String razaoSocial;
    
    @NotBlank(message = "O porte da empresa é obrigatória")
    private String porteDaEmpresa;
    
    private LocalDate dataAberturaEmpresa;
    
    private Integer qtdFuncionarios;
}

