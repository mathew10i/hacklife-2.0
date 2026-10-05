package com.hacklife.habitstreak.infrastructure.rest;

import com.hacklife.habitstreak.application.command.CreateHabitCommand;
import com.hacklife.habitstreak.application.port.in.CreateHabitUseCase;
import com.hacklife.habitstreak.domain.model.Habit;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/habits")
public class HabitController {

    private final CreateHabitUseCase createHabitUseCase;

    public HabitController(CreateHabitUseCase createHabitUseCase) {
        this.createHabitUseCase = createHabitUseCase;
    }

    @PostMapping
    public ResponseEntity<CreateHabitResponse> createHabit(@Valid @RequestBody CreateHabitRequest request) {
        Habit habit = createHabitUseCase.create(new CreateHabitCommand(
                request.userId(),
                request.name(),
                request.frequency()
        ));
        return ResponseEntity.status(HttpStatus.CREATED).body(CreateHabitResponse.from(habit));
    }
}
