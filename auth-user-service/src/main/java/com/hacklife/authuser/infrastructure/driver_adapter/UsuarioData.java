package com.hacklife.authuser.infrastructure.driver_adapter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "usuarios_auth")
public class UsuarioData {

    @Id
    @Column(nullable = false, updatable = false)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String correo;

    @Column(nullable = false)
    private String nombre;

    @Column(name = "creado_en", nullable = false)
    private Instant creadoEn;

    protected UsuarioData() {
    }

    public UsuarioData(UUID id, String correo, String nombre, Instant creadoEn) {
        this.id = id;
        this.correo = correo;
        this.nombre = nombre;
        this.creadoEn = creadoEn;
    }

    public UUID getId() {
        return id;
    }

    public String getCorreo() {
        return correo;
    }

    public String getNombre() {
        return nombre;
    }

    public Instant getCreadoEn() {
        return creadoEn;
    }
}
