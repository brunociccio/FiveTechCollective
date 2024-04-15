package br.com.fiap.fivetechcolletive.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.fivetechcolletive.model.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Integer> {
    Contato findByEmail(String email);
    Contato findByTelefoneCelular(String celular);
}