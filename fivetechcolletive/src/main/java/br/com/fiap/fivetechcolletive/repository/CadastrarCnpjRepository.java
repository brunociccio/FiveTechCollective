package br.com.fiap.fivetechcolletive.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.fivetechcolletive.model.CadastrarCnpj;

public interface CadastrarCnpjRepository extends JpaRepository<CadastrarCnpj, Integer> {
    CadastrarCnpj findById(int id);
}

