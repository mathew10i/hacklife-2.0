package com.hacklife.habitstreak.infrastructure.mappers;

import com.hacklife.habitstreak.domain.model.Habito;
import com.hacklife.habitstreak.infrastructure.driver_adapter.HabitoData;
import org.springframework.stereotype.Component;

@Component
public class HabitoMapper {

    public HabitoData toData(Habito habito) {
        return new HabitoData(habito.id(), habito.usuarioId(), habito.nombre(), habito.frecuencia(), habito.creadoEn());
    }

    public Habito toDomain(HabitoData data) {
        return new Habito(data.getId(), data.getUsuarioId(), data.getNombre(), data.getFrecuencia(), data.getCreadoEn());
    }
}
