package io.github.anajordao.clientes.model.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity // informa q é uma entidade da dependencia jpa
// @Getter@Setter  // em tempo de compilação os getters e setters são gerados
@Data // cria getters, setters, toString, construtor s/ param e com params obrigatorios 
@NoArgsConstructor // manter o construtor sem args
@AllArgsConstructor // gera um construtor com tds os atributos
@Builder // gera um builder do cliente
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // deixa o banco popular o id e fazer o autoincremento
    private Integer id;

    @Column(nullable = false, length = 150)
    private String nome;

    @Column(nullable = false, length = 11)
    private String cpf;

    @Column(name = "data_cadastro")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCadastro; 

    @PrePersist
    public void prePersist(){
        setDataCadastro(LocalDate.now());
    }
}
