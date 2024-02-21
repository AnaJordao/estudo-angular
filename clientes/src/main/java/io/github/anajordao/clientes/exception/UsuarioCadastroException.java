package io.github.anajordao.clientes.exception;

public class UsuarioCadastroException extends RuntimeException{
    public UsuarioCadastroException(String login) {
        super("Usuário já cadastrou para o login " + login);
    }
}
