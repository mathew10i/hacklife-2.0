package com.hacklife.goalprogress.infrastructure.driver_adapter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "objetivos")
public class ObjetivoData {

    @Id
    @Column(nullable = false, updatable = false)
    private UUID id;

    @Column(name = "usuario_id", nullable = false)
    private UUID usuarioId;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private Integer meta;

    @Column(name = "creado_en", nullable = false)
    private Instant creadoEn;

    protected ObjetivoData() {
    }

    public ObjetivoData(UUID id, UUID usuarioId, String titulo, Integer meta, Instant creadoEn) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.titulo = titulo;
        this.meta = meta;
        this.creadoEn = creadoEn;
    }

    public UUID getId() {
        return id;
    }

    public UUID getUsuarioId() {
        return usuarioId;
    }

    public String getTitulo() {
        return titulo;
    }

    public Integer getMeta() {
        return meta;
    }

    public Instant getCreadoEn() {
        return creadoEn;
    }
}
