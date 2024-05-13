package br.com.fiap.fivetechcolletive.model;

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
public class Endereco {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEndereco;
    
    @NotBlank(message = "O CEP é obrigatório")
    private String cep;
    
    @NotBlank(message = "O logradouro é obrigatório")
    private String logradouro;
    
    private Integer numero;
    private String complemento;
    
    @NotBlank(message = "O bairro é obrigatório")
    private String bairro;
    
    @NotBlank(message = "A cidade é obrigatória")
    private String cidade;
    
    @NotBlank(message = "O estado é obrigatório")
    private String estado;
}
