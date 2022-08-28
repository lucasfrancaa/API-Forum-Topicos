package com.campomagico.forum.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    // SERVE PARA CONFIGURAR A PARTE DE AUTENTICAÇÃO
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

    }

    // SERVE PARA FAZER CONFIGURAÇÕES DE AUTORIZAÇÃO (PERFIL DE ACESSO, QUEM ACESSA A URL)
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests().antMatchers(HttpMethod.GET, "/topicos").permitAll().antMatchers(HttpMethod.GET, "/topicos/*").permitAll();
    }

    // SERVE PARA FAZER CONFIGURAÇÕES DE RECURSOS ESTÁTICOS (REQUISIÇÕES PARA CSS, JS, IMAGENS...)
    @Override
    public void configure(WebSecurity web) throws Exception {

    }
}


