package br.com.fiap.fivetechcolletive.config;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.fiap.fivetechcolletive.repository.CadastrarCnpjRepository;
import br.com.fiap.fivetechcolletive.repository.CadastroRepository;
import br.com.fiap.fivetechcolletive.repository.ContatoRepository;
import br.com.fiap.fivetechcolletive.repository.DocumentosRepository;
import br.com.fiap.fivetechcolletive.repository.EnderecoRepository;

@Configuration
@Profile("dev")
public class DataBaseSeeder implements CommandLineRunner {

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

@Override
public void run(String... args) throws Exception {

    cadastroRepository.saveAll(
        List.of()
    );  
    
    cadastrarCnpjRepository.saveAll(
        List.of()
    );

    contatoRepository.saveAll(
        List.of()
    );

    documentosRepository.saveAll(
        List.of()
    );

    enderecoRepository.saveAll(
        List.of()
    );

}
    
}
