package br.com.projeto.api;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Target(ElementType.FIELD) // essa annotation é elegível para atributo
@Retention(RetentionPolicy.RUNTIME)
@Autowired
@Qualifier("gato")
public @interface Gato {
    
}
