package com.hacklife.gamification.infrastructure.driver_adapter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "puntos_gamification")
public class PuntosData {

    @Id
    @Column(nullable = false, updatable = false)
    private UUID id;

    @Column(name = "usuario_id", nullable = false)
    private UUID usuarioId;

    @Column(nullable = false)
    private Integer valor;

    @Column(nullable = false)
    private String motivo;

    @Column(name = "asignado_en", nullable = false)
    private Instant asignadoEn;

    protected PuntosData() {
    }

    public PuntosData(UUID id, UUID usuarioId, Integer valor, String motivo, Instant asignadoEn) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.valor = valor;
        this.motivo = motivo;
        this.asignadoEn = asignadoEn;
    }

    public UUID getId() {
        return id;
    }

    public UUID getUsuarioId() {
        return usuarioId;
    }

    public Integer getValor() {
        return valor;
    }

    public String getMotivo() {
        return motivo;
    }

    public Instant getAsignadoEn() {
        return asignadoEn;
    }
}
