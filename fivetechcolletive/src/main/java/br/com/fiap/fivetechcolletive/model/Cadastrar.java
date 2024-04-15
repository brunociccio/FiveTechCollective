package br.com.fiap.fivetechcolletive.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Data
public class Cadastrar {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCadastrar;

    @NotBlank(message = "O nome é obrigatório")
    private String nome;

    @Temporal(TemporalType.DATE)
    private Date dataNascimento;

    // Sexo é opcional e pode ser 'M' (masculino), 'F' (feminino), ou 'não informado'
    @Size(min = 1, max = 1)
    private String sexo;

    @NotBlank(message = "A escolaridade é obrigatória")
    private String escolaridade;

    @NotBlank(message = "A profissão é obrigatória")
    private String profissao;

    @Positive(message = "A renda deve ser um número positivo")
    private Double renda;

}
