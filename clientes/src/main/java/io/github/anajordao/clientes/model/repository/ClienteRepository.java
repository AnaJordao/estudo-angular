package io.github.anajordao.clientes.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.anajordao.clientes.model.entity.Cliente;

// o repositorio inclui todos os metodos, como ordenacao e operacoes de crud
// primeiro param = a entidade na qual o repositorio irá trabalhar
// segundo param = o tipo da chave primaria
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    
}
