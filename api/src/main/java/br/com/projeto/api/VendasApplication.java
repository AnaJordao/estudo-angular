package br.com.projeto.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// @SpringBootApplication
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
// bom para escanear bibliotecas/pacotes externos
// @ComponentScan(basePackages = {
//         "br.com.projeto.api.repository",
//         "br.com.projeto.api.service",
//         "com.umaoutrabiblioteca.projeto"
// })
@RestController
public class VendasApplication { // Ctrl + F5 para rodar
    
    @Cachorro
    // @Gato
    private Animal animal;

    @Bean(name="executarAnimal")
    public CommandLineRunner executar() {
        return args -> {
            this.animal.fazerBarulho();
        };
    }


    // config personalizada
    // @Autowired
    // @Qualifier("applicationName")
    // application.properties
    @Value("${application.name}")
    private String applicationName;

    @GetMapping("/hello")   // rota /hello executa o método abaixo
    public String helloWorld() {
        return applicationName;
    }

    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }
}
