package com.hacklife.habitstreak.infrastructure.driver_adapter;

import com.hacklife.habitstreak.domain.model.FrecuenciaHabito;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "habitos")
public class HabitoData {

    @Id
    @Column(nullable = false, updatable = false)
    private UUID id;

    @Column(name = "usuario_id", nullable = false)
    private UUID usuarioId;

    @Column(nullable = false)
    private String nombre;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private FrecuenciaHabito frecuencia;

    @Column(name = "creado_en", nullable = false)
    private Instant creadoEn;

    protected HabitoData() {
    }

    public HabitoData(UUID id, UUID usuarioId, String nombre, FrecuenciaHabito frecuencia, Instant creadoEn) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.nombre = nombre;
        this.frecuencia = frecuencia;
        this.creadoEn = creadoEn;
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

    public FrecuenciaHabito getFrecuencia() {
        return frecuencia;
    }

    public Instant getCreadoEn() {
        return creadoEn;
    }
}
