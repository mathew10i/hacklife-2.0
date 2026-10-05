package com.hacklife.gamification.infrastructure.mappers;

import com.hacklife.gamification.domain.model.Puntos;
import com.hacklife.gamification.infrastructure.driver_adapter.PuntosData;
import org.springframework.stereotype.Component;

@Component
public class PuntosMapper {

    public PuntosData toData(Puntos puntos) {
        return new PuntosData(puntos.id(), puntos.usuarioId(), puntos.valor(), puntos.motivo(), puntos.asignadoEn());
    }

    public Puntos toDomain(PuntosData data) {
        return new Puntos(data.getId(), data.getUsuarioId(), data.getValor(), data.getMotivo(), data.getAsignadoEn());
    }
}
