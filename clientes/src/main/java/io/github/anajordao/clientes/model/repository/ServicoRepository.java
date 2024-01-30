package io.github.anajordao.clientes.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.anajordao.clientes.model.entity.Servico;

public interface ServicoRepository extends JpaRepository<Servico, Integer> {
    
}
