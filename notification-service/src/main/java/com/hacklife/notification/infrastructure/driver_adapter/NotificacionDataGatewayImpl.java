package com.hacklife.notification.infrastructure.driver_adapter;

import com.hacklife.notification.domain.model.Notificacion;
import com.hacklife.notification.domain.model.gateway.NotificacionGateway;
import com.hacklife.notification.infrastructure.mappers.NotificacionMapper;
import org.springframework.stereotype.Component;

@Component
public class NotificacionDataGatewayImpl implements NotificacionGateway {

    private final NotificacionDataJpaRepository notificacionDataJpaRepository;
    private final NotificacionMapper notificacionMapper;

    public NotificacionDataGatewayImpl(NotificacionDataJpaRepository notificacionDataJpaRepository, NotificacionMapper notificacionMapper) {
        this.notificacionDataJpaRepository = notificacionDataJpaRepository;
        this.notificacionMapper = notificacionMapper;
    }

    @Override
    public Notificacion guardar(Notificacion notificacion) {
        NotificacionData saved = notificacionDataJpaRepository.save(notificacionMapper.toData(notificacion));
        return notificacionMapper.toDomain(saved);
    }
}
