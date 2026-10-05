package com.hacklife.habitstreak.infrastructure.driver_adapter;

import com.hacklife.habitstreak.domain.model.Habito;
import com.hacklife.habitstreak.domain.model.gateway.HabitoGateway;
import com.hacklife.habitstreak.infrastructure.mappers.HabitoMapper;
import org.springframework.stereotype.Component;

@Component
public class HabitoDataGatewayImpl implements HabitoGateway {

    private final HabitoDataJpaRepository habitoDataJpaRepository;
    private final HabitoMapper habitoMapper;

    public HabitoDataGatewayImpl(HabitoDataJpaRepository habitoDataJpaRepository, HabitoMapper habitoMapper) {
        this.habitoDataJpaRepository = habitoDataJpaRepository;
        this.habitoMapper = habitoMapper;
    }

    @Override
    public Habito guardar(Habito habito) {
        HabitoData saved = habitoDataJpaRepository.save(habitoMapper.toData(habito));
        return habitoMapper.toDomain(saved);
    }
}
