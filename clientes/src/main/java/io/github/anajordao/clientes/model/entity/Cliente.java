package io.github.anajordao.clientes.model.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // informa q é uma entidade da dependencia jpa
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // deixa o banco popular o id e fazer o autoincremento
    private Integer id;

    @Column(nullable = false, length = 150)
    private String nome;

    @Column(nullable = false, length = 11)
    private String cpf;

    @Column
    private LocalDate dataCadastro; 
}
