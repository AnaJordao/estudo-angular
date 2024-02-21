package io.github.anajordao.clientes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import io.github.anajordao.clientes.exception.UsuarioCadastroException;
import io.github.anajordao.clientes.model.entity.Usuario;
import io.github.anajordao.clientes.model.repository.UsuarioRepository;
import org.springframework.security.core.userdetails.User;

@Service
public class UsuarioService implements UserDetailsService{
    
    @Autowired
    private UsuarioRepository repository;

    public Usuario salvar(Usuario usuario){
        boolean exists = repository.existsByUsername(usuario.getUsername());
        if(exists){
            throw new UsuarioCadastroException(usuario.getUsername());
        }
        return repository.save(usuario);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = repository
                            .findByUsername(username)
                            .orElseThrow(() -> new UsernameNotFoundException("Login não encontrado."));

                            return User
                                    .builder()
                                    .username(usuario.getUsername())
                                    .password(usuario.getPassword())
                                    .roles("USER")
                                    .build();
    }

}
