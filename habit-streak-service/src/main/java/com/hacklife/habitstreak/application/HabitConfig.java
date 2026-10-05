package com.hacklife.habitstreak.application;

import com.hacklife.habitstreak.domain.model.gateway.HabitoGateway;
import com.hacklife.habitstreak.domain.usecase.CrearHabitoUseCase;
import com.hacklife.habitstreak.domain.usecase.CrearHabitoUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Clock;

@Configuration
public class HabitConfig {

    @Bean
    public Clock habitClock() {
        return Clock.systemUTC();
    }

    @Bean
    public CrearHabitoUseCase crearHabitoUseCase(HabitoGateway habitoGateway, Clock habitClock) {
        return new CrearHabitoUseCaseImpl(habitoGateway, habitClock);
    }
}
