package br.com.projeto.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // o Spring Boot escaneia as classes de config 
               // e configura a partir delas
public class MyConfiguration {
    
    // se não passar nome pro Bean, ele pega o nome do método
    @Bean(name = "applicationName") 
    public String applicationName(){
        return "Sistema de Vendas";
    }
}
