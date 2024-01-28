package br.com.projeto.api.repository;

import org.springframework.stereotype.Repository;

import br.com.projeto.api.model.Cliente;

@Repository // acessa a database diretamente
public class ClientesRepository {
    public void persistir(Cliente cliente) {
        // acessa a base e salva o cliente
    }
}
