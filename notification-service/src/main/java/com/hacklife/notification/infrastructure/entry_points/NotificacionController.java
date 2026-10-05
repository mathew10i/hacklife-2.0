package com.hacklife.notification.infrastructure.entry_points;

import com.hacklife.notification.domain.model.Notificacion;
import com.hacklife.notification.domain.usecase.CrearNotificacionUseCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/notificaciones")
public class NotificacionController {

    private final CrearNotificacionUseCase crearNotificacionUseCase;

    public NotificacionController(CrearNotificacionUseCase crearNotificacionUseCase) {
        this.crearNotificacionUseCase = crearNotificacionUseCase;
    }

    @PostMapping
    public ResponseEntity<NotificacionResponse> crear(@Valid @RequestBody CrearNotificacionRequest request) {
        Notificacion notificacion = crearNotificacionUseCase.crear(request.usuarioId(), request.mensaje());
        return ResponseEntity.status(HttpStatus.CREATED).body(NotificacionResponse.from(notificacion));
    }
}
