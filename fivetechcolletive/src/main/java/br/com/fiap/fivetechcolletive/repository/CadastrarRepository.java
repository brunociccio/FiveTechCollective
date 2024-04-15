package br.com.fiap.fivetechcolletive.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.fivetechcolletive.model.Cadastrar;

@Repository
public interface CadastrarRepository extends JpaRepository<Cadastrar, Long> {

}
