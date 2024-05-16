package br.com.fiap.fivetechcolletive.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.fiap.fivetechcolletive.repository.CadastrarCnpjRepository;
import br.com.fiap.fivetechcolletive.repository.CadastroRepository;
import br.com.fiap.fivetechcolletive.repository.ContatoRepository;
import br.com.fiap.fivetechcolletive.repository.DocumentosRepository;
import br.com.fiap.fivetechcolletive.repository.EnderecoRepository;

@Configuration
@Profile("dev")
public class DataBaseSeeder {

@Autowired
CadastroRepository cadastroRepository;

@Autowired
public
CadastrarCnpjRepository cadastrarCnpjRepository;

@Autowired
ContatoRepository contatoRepository;

@Autowired
DocumentosRepository documentosRepository;

@Autowired
EnderecoRepository enderecoRepository;
    
}
