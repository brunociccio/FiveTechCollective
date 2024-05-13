package br.com.fiap.fivetechcolletive.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
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

