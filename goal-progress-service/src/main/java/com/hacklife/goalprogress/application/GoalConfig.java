package com.hacklife.goalprogress.application;

import com.hacklife.goalprogress.domain.model.gateway.ObjetivoGateway;
import com.hacklife.goalprogress.domain.usecase.CrearObjetivoUseCase;
import com.hacklife.goalprogress.domain.usecase.CrearObjetivoUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Clock;

@Configuration
public class GoalConfig {

    @Bean
    public Clock goalClock() {
        return Clock.systemUTC();
    }

    @Bean
    public CrearObjetivoUseCase crearObjetivoUseCase(ObjetivoGateway objetivoGateway, Clock goalClock) {
        return new CrearObjetivoUseCaseImpl(objetivoGateway, goalClock);
    }
}
