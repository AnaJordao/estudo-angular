package br.com.projeto.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// @SpringBootApplication
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@RestController
public class VendasApplication { // Ctrl + F5 para rodar
    
    @Autowired
    @Qualifier("applicationName")
    private String applicationName;

    @GetMapping("/hello")   // rota /hello executa o método abaixo
    public String helloWorld() {
        return applicationName;
    }

    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }
}
