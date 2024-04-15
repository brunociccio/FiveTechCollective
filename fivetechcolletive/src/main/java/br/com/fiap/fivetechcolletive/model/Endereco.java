package br.com.fiap.fivetechcolletive.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Entity
@Data
public class Endereco {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEndereco;
    
    @NotBlank(message = "O CEP é obrigatório")
    private String cep;
    
    private String logradouro;
    private int numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;

    /* 
    // Método para preencher automaticamente as informações do endereço com base no CEP
    public void preencherEnderecoAutomatico() {
        // Criar uma instância do RestTemplate para fazer a requisição HTTP
        RestTemplate restTemplate = new RestTemplate();
        
        // URL da API do Postmon com o CEP a ser consultado
        String url = "https://api.postmon.com.br/v1/cep/" + cep;
        
        // Fazer a requisição GET para a API do Postmon e receber a resposta como um objeto Endereco
        Endereco endereco = restTemplate.getForObject(url, Endereco.class);
        
        // Preencher os atributos do endereço com base na resposta da API
        if (endereco != null) {
            this.logradouro = endereco.getLogradouro();
            this.numero = endereco.getNumero();
            this.complemento = endereco.getComplemento();
            this.bairro = endereco.getBairro();
            this.cidade = endereco.getCidade();
            this.estado = endereco.getEstado();
        }
    }*/
}
