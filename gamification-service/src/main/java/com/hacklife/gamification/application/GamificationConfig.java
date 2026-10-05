package com.hacklife.gamification.application;

import com.hacklife.gamification.domain.model.gateway.PuntosGateway;
import com.hacklife.gamification.domain.usecase.AsignarPuntosUseCase;
import com.hacklife.gamification.domain.usecase.AsignarPuntosUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Clock;

@Configuration
public class GamificationConfig {

    @Bean
    public Clock gamificationClock() {
        return Clock.systemUTC();
    }

    @Bean
    public AsignarPuntosUseCase asignarPuntosUseCase(PuntosGateway puntosGateway, Clock gamificationClock) {
        return new AsignarPuntosUseCaseImpl(puntosGateway, gamificationClock);
    }
}
