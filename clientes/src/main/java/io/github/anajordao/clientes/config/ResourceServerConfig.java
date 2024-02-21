// package io.github.anajordao.clientes.config;

// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
// import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

// @Configuration
// @EnableResourceServer
// public class ResourceServerConfig extends ResourceServerConfigurerAdapter{
    
//     // quem tem permissao para acessar qual api
//     @Override
//     public void configure(HttpSecurity http) throws Exception {
//         http
//             .authorizeRequests()
//             .requestMatchers("/api/usuarios").permitAll()
//                 .requestMatchers("/api/clientes/**", "/api/servicos-prestados/**").authenticated()
//                 .anyRequest().denyAll();
//     }
// }
