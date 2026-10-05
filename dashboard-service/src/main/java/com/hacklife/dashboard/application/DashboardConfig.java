package com.hacklife.dashboard.application;

import com.hacklife.dashboard.domain.model.gateway.MetricaGateway;
import com.hacklife.dashboard.domain.usecase.RegistrarMetricaUseCase;
import com.hacklife.dashboard.domain.usecase.RegistrarMetricaUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Clock;

@Configuration
public class DashboardConfig {

    @Bean
    public Clock dashboardClock() {
        return Clock.systemUTC();
    }

    @Bean
    public RegistrarMetricaUseCase registrarMetricaUseCase(MetricaGateway metricaGateway, Clock dashboardClock) {
        return new RegistrarMetricaUseCaseImpl(metricaGateway, dashboardClock);
    }
}
