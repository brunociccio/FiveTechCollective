package br.com.fiap.fivetechcolletive.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
public class Contato {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idContato;
    
    @Email(message = "O email deve ser válido")
    private String email;
    
    @NotBlank(message = "O telefone fixo é obrigatório")
    private String telefoneFixo;
    
    @NotBlank(message = "O celular é obrigatório")
    private String telefoneCelular;

}
