package com.hacklife.authuser.application;

import com.hacklife.authuser.domain.model.gateway.UsuarioGateway;
import com.hacklife.authuser.domain.usecase.RegistrarUsuarioUseCase;
import com.hacklife.authuser.domain.usecase.RegistrarUsuarioUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Clock;

@Configuration
public class AuthConfig {

    @Bean
    public Clock authClock() {
        return Clock.systemUTC();
    }

    @Bean
    public RegistrarUsuarioUseCase registrarUsuarioUseCase(UsuarioGateway usuarioGateway, Clock authClock) {
        return new RegistrarUsuarioUseCaseImpl(usuarioGateway, authClock);
    }
}
