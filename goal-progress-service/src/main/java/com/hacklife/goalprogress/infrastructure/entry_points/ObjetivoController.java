package com.hacklife.goalprogress.infrastructure.entry_points;

import com.hacklife.goalprogress.domain.model.Objetivo;
import com.hacklife.goalprogress.domain.usecase.CrearObjetivoUseCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/objetivos")
public class ObjetivoController {

    private final CrearObjetivoUseCase crearObjetivoUseCase;

    public ObjetivoController(CrearObjetivoUseCase crearObjetivoUseCase) {
        this.crearObjetivoUseCase = crearObjetivoUseCase;
    }

    @PostMapping
    public ResponseEntity<ObjetivoResponse> crear(@Valid @RequestBody CrearObjetivoRequest request) {
        Objetivo objetivo = crearObjetivoUseCase.crear(request.usuarioId(), request.titulo(), request.meta());
        return ResponseEntity.status(HttpStatus.CREATED).body(ObjetivoResponse.from(objetivo));
    }
}
