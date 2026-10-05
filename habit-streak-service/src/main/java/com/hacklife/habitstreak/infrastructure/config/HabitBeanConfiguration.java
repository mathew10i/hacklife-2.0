package com.hacklife.habitstreak.infrastructure.config;

import com.hacklife.habitstreak.application.port.in.CreateHabitUseCase;
import com.hacklife.habitstreak.application.port.out.HabitRepositoryPort;
import com.hacklife.habitstreak.application.usecase.CreateHabitService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Clock;

@Configuration
public class HabitBeanConfiguration {

    @Bean
    public CreateHabitUseCase createHabitUseCase(HabitRepositoryPort habitRepositoryPort, Clock clock) {
        return new CreateHabitService(habitRepositoryPort, clock);
    }
}
