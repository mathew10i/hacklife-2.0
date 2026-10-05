package com.hacklife.gamification.infrastructure.entry_points;

import com.hacklife.gamification.domain.model.Puntos;
import com.hacklife.gamification.domain.usecase.AsignarPuntosUseCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/puntos")
public class PuntosController {

    private final AsignarPuntosUseCase asignarPuntosUseCase;

    public PuntosController(AsignarPuntosUseCase asignarPuntosUseCase) {
        this.asignarPuntosUseCase = asignarPuntosUseCase;
    }

    @PostMapping
    public ResponseEntity<PuntosResponse> asignar(@Valid @RequestBody AsignarPuntosRequest request) {
        Puntos puntos = asignarPuntosUseCase.asignar(request.usuarioId(), request.valor(), request.motivo());
        return ResponseEntity.status(HttpStatus.CREATED).body(PuntosResponse.from(puntos));
    }
}
