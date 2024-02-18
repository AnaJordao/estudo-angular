package io.github.anajordao.clientes.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.anajordao.clientes.model.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    
}
