package com.hacklife.authuser.infrastructure.driver_adapter;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UsuarioDataJpaRepository extends JpaRepository<UsuarioData, UUID> {
}
