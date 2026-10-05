package com.hacklife.gamification.infrastructure.driver_adapter;

import com.hacklife.gamification.domain.model.Puntos;
import com.hacklife.gamification.domain.model.gateway.PuntosGateway;
import com.hacklife.gamification.infrastructure.mappers.PuntosMapper;
import org.springframework.stereotype.Component;

@Component
public class PuntosDataGatewayImpl implements PuntosGateway {

    private final PuntosDataJpaRepository puntosDataJpaRepository;
    private final PuntosMapper puntosMapper;

    public PuntosDataGatewayImpl(PuntosDataJpaRepository puntosDataJpaRepository, PuntosMapper puntosMapper) {
        this.puntosDataJpaRepository = puntosDataJpaRepository;
        this.puntosMapper = puntosMapper;
    }

    @Override
    public Puntos guardar(Puntos puntos) {
        PuntosData saved = puntosDataJpaRepository.save(puntosMapper.toData(puntos));
        return puntosMapper.toDomain(saved);
    }
}
