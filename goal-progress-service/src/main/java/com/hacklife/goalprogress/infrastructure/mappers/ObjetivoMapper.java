package com.hacklife.goalprogress.infrastructure.mappers;

import com.hacklife.goalprogress.domain.model.Objetivo;
import com.hacklife.goalprogress.infrastructure.driver_adapter.ObjetivoData;
import org.springframework.stereotype.Component;

@Component
public class ObjetivoMapper {

    public ObjetivoData toData(Objetivo objetivo) {
        return new ObjetivoData(objetivo.id(), objetivo.usuarioId(), objetivo.titulo(), objetivo.meta(), objetivo.creadoEn());
    }

    public Objetivo toDomain(ObjetivoData data) {
        return new Objetivo(data.getId(), data.getUsuarioId(), data.getTitulo(), data.getMeta(), data.getCreadoEn());
    }
}
