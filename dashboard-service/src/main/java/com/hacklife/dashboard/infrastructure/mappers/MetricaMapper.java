package com.hacklife.dashboard.infrastructure.mappers;

import com.hacklife.dashboard.domain.model.Metrica;
import com.hacklife.dashboard.infrastructure.driver_adapter.MetricaData;
import org.springframework.stereotype.Component;

@Component
public class MetricaMapper {

    public MetricaData toData(Metrica metrica) {
        return new MetricaData(
                metrica.id(),
                metrica.usuarioId(),
                metrica.nombre(),
                metrica.valor(),
                metrica.registradaEn()
        );
    }

    public Metrica toDomain(MetricaData data) {
        return new Metrica(data.getId(), data.getUsuarioId(), data.getNombre(), data.getValor(), data.getRegistradaEn());
    }
}
