package br.com.fiap.fivetechcolletive.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;

import lombok.Data;

@Entity
@Data
public class Contato {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idContato;
    
    @Email(message = "O email deve ser válido")
    private String email;
    
    private String telefoneFixo;
    
    private String telefoneCelular;

}
