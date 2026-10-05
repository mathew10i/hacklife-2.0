package com.hacklife.dashboard.infrastructure.driver_adapter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "metricas_dashboard")
public class MetricaData {

    @Id
    @Column(nullable = false, updatable = false)
    private UUID id;

    @Column(name = "usuario_id", nullable = false)
    private UUID usuarioId;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private Double valor;

    @Column(name = "registrada_en", nullable = false)
    private Instant registradaEn;

    protected MetricaData() {
    }

    public MetricaData(UUID id, UUID usuarioId, String nombre, Double valor, Instant registradaEn) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.nombre = nombre;
        this.valor = valor;
        this.registradaEn = registradaEn;
    }

    public UUID getId() {
        return id;
    }

    public UUID getUsuarioId() {
        return usuarioId;
    }

    public String getNombre() {
        return nombre;
    }

    public Double getValor() {
        return valor;
    }

    public Instant getRegistradaEn() {
        return registradaEn;
    }
}
