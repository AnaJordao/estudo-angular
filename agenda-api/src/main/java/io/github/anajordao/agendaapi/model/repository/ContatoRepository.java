package io.github.anajordao.agendaapi.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.anajordao.agendaapi.model.entity.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Integer>{
    
}
