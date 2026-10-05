package com.hacklife.dashboard.infrastructure.entry_points;

import com.hacklife.dashboard.domain.model.Metrica;
import com.hacklife.dashboard.domain.usecase.RegistrarMetricaUseCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/metricas")
public class MetricaController {

    private final RegistrarMetricaUseCase registrarMetricaUseCase;

    public MetricaController(RegistrarMetricaUseCase registrarMetricaUseCase) {
        this.registrarMetricaUseCase = registrarMetricaUseCase;
    }

    @PostMapping
    public ResponseEntity<MetricaResponse> registrar(@Valid @RequestBody RegistrarMetricaRequest request) {
        Metrica metrica = registrarMetricaUseCase.registrar(request.usuarioId(), request.nombre(), request.valor());
        return ResponseEntity.status(HttpStatus.CREATED).body(MetricaResponse.from(metrica));
    }
}
