package com.hacklife.goalprogress.infrastructure.driver_adapter;

import com.hacklife.goalprogress.domain.model.Objetivo;
import com.hacklife.goalprogress.domain.model.gateway.ObjetivoGateway;
import com.hacklife.goalprogress.infrastructure.mappers.ObjetivoMapper;
import org.springframework.stereotype.Component;

@Component
public class ObjetivoDataGatewayImpl implements ObjetivoGateway {

    private final ObjetivoDataJpaRepository objetivoDataJpaRepository;
    private final ObjetivoMapper objetivoMapper;

    public ObjetivoDataGatewayImpl(ObjetivoDataJpaRepository objetivoDataJpaRepository, ObjetivoMapper objetivoMapper) {
        this.objetivoDataJpaRepository = objetivoDataJpaRepository;
        this.objetivoMapper = objetivoMapper;
    }

    @Override
    public Objetivo guardar(Objetivo objetivo) {
        ObjetivoData saved = objetivoDataJpaRepository.save(objetivoMapper.toData(objetivo));
        return objetivoMapper.toDomain(saved);
    }
}
