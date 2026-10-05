package com.hacklife.notification.infrastructure.driver_adapter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "notificaciones")
public class NotificacionData {

    @Id
    @Column(nullable = false, updatable = false)
    private UUID id;

    @Column(name = "usuario_id", nullable = false)
    private UUID usuarioId;

    @Column(nullable = false)
    private String mensaje;

    @Column(name = "creada_en", nullable = false)
    private Instant creadaEn;

    protected NotificacionData() {
    }

    public NotificacionData(UUID id, UUID usuarioId, String mensaje, Instant creadaEn) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.mensaje = mensaje;
        this.creadaEn = creadaEn;
    }

    public UUID getId() {
        return id;
    }

    public UUID getUsuarioId() {
        return usuarioId;
    }

    public String getMensaje() {
        return mensaje;
    }

    public Instant getCreadaEn() {
        return creadaEn;
    }
}
