package io.github.anajordao.clientes.rest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import io.github.anajordao.clientes.model.entity.Cliente;
import io.github.anajordao.clientes.model.entity.ServicoPrestado;
import io.github.anajordao.clientes.model.repository.ClienteRepository;
import io.github.anajordao.clientes.model.repository.ServicoPrestadoRepository;
import io.github.anajordao.clientes.rest.dto.ServicoPrestadoDTO;
import io.github.anajordao.clientes.util.BigDecimalConverter;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/servicos-prestados")
@RequiredArgsConstructor // faz um construtor com todos os atributos da classe
public class ServicoPrestadoController {
    
    private final ClienteRepository clienteRepository;
    private final ServicoPrestadoRepository repository;
    private final BigDecimalConverter bigDecimalConverter;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ServicoPrestado salvar(@RequestBody @Valid ServicoPrestadoDTO dto){
        LocalDate data = LocalDate.parse(dto.getData(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        Integer idCliente = dto.getIdCliente();

        Cliente cliente = clienteRepository
                                                .findById(idCliente)
                                                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cliente inexistente."));

        ServicoPrestado servicoPrestado = new ServicoPrestado();
        servicoPrestado.setDescricao(dto.getDescricao());
        servicoPrestado.setData(data);
        servicoPrestado.setValor(bigDecimalConverter.converter((dto.getPreco())));
        servicoPrestado.setCliente(cliente);
        
        return repository.save(servicoPrestado);
    }

    @GetMapping
    public List<ServicoPrestado> pesquisar(
        @RequestParam(value = "nome", required = false, defaultValue = "") String nome,
        @RequestParam(value = "mes", required = false) Integer mes
    ){
        return repository.fingByNomeCliente("%" + nome + "%", mes); // para conseguir achar só com um pedaco do nome
    }
}
