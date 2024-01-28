package br.com.projeto.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.projeto.api.model.Cliente;
import br.com.projeto.api.repository.ClientesRepository;

@Service // regras de negocio
public class ClientesService {
    
    // injecao de dependencias via atributo (só colocar a tag @Autowired)
    @Autowired 
    private ClientesRepository repository;

    // injecao de dependencias via construtor
    // @Autowired // pode omitir a tag quando usar no construtor
    // public ClientesService(ClientesRepository repository){ // injeçao de dependencias
    //     this.repository = repository;
    // }

    // injecao de dependencias via metodo set
    // @Autowired
    // public void setRepository(ClientesRepository repository){ // injeçao de dependencias
    //     this.repository = repository;
    // }

    public void salvarCliente(Cliente cliente){
        validarCliente(cliente);
        // ClientesRepository clientesRepository = new ClientesRepository(); // não eh bom fazer assim pois o repository acessa a base diretamente (evitar muitas chamadas a base)
        // clientesRepository.persistir(cliente);
        this.repository.persistir(cliente);
    }
    
    public void validarCliente(Cliente cliente){
        //aplicar validações
    }
}
