package br.com.projeto.api;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration // o Spring Boot escaneia as classes de config 
               // e configura a partir delas
// @Profile("development") // só roda no ambiente de desenvolvimento
// @Profile("production") // só roda no ambiente de producao
@Development // a annotation personalizada
public class MyConfiguration {
    
    // se não passar nome pro Bean, ele pega o nome do método
    // @Bean(name = "applicationName") 
    // public String applicationName(){
    //     return "Sistema de Vendas";
    // }

    @Bean
    public CommandLineRunner executar() {
        return args -> {
            System.out.println("RODANDO A CONFIGURAÇÃO DE DESENVOLVIMENTO");
        };
    }
}
