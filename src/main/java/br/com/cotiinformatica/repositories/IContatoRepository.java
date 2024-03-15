package br.com.cotiinformatica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cotiinformatica.entities.Contato;

public interface IContatoRepository extends JpaRepository <Contato, Integer> {

}
