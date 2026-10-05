package com.hacklife.dashboard.infrastructure.driver_adapter;

import com.hacklife.dashboard.domain.model.Metrica;
import com.hacklife.dashboard.domain.model.gateway.MetricaGateway;
import com.hacklife.dashboard.infrastructure.mappers.MetricaMapper;
import org.springframework.stereotype.Component;

@Component
public class MetricaDataGatewayImpl implements MetricaGateway {

    private final MetricaDataJpaRepository metricaDataJpaRepository;
    private final MetricaMapper metricaMapper;

    public MetricaDataGatewayImpl(MetricaDataJpaRepository metricaDataJpaRepository, MetricaMapper metricaMapper) {
        this.metricaDataJpaRepository = metricaDataJpaRepository;
        this.metricaMapper = metricaMapper;
    }

    @Override
    public Metrica guardar(Metrica metrica) {
        MetricaData saved = metricaDataJpaRepository.save(metricaMapper.toData(metrica));
        return metricaMapper.toDomain(saved);
    }
}
