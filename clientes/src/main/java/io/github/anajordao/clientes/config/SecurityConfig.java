package io.github.anajordao.clientes.config;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@EnableWebSecurity
@EnableResourceServer
@EnableAuthorizationServer
// public class SecurityConfig extends AuthorizationServerConfigurerAdapter {
public class SecurityConfig implements WebMvcConfigurer {
    
}
