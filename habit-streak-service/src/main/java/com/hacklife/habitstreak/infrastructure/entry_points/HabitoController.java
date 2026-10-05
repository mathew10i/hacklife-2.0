package com.hacklife.habitstreak.infrastructure.entry_points;

import com.hacklife.habitstreak.domain.model.Habito;
import com.hacklife.habitstreak.domain.usecase.CrearHabitoUseCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/habitos")
public class HabitoController {

    private final CrearHabitoUseCase crearHabitoUseCase;

    public HabitoController(CrearHabitoUseCase crearHabitoUseCase) {
        this.crearHabitoUseCase = crearHabitoUseCase;
    }

    @PostMapping
    public ResponseEntity<HabitoResponse> crear(@Valid @RequestBody CrearHabitoRequest request) {
        Habito habito = crearHabitoUseCase.crear(request.usuarioId(), request.nombre(), request.frecuencia());
        return ResponseEntity.status(HttpStatus.CREATED).body(HabitoResponse.from(habito));
    }
}
