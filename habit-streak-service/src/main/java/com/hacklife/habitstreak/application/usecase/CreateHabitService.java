package com.hacklife.habitstreak.application.usecase;

import com.hacklife.habitstreak.application.command.CreateHabitCommand;
import com.hacklife.habitstreak.application.port.in.CreateHabitUseCase;
import com.hacklife.habitstreak.application.port.out.HabitRepositoryPort;
import com.hacklife.habitstreak.domain.model.Habit;
import com.hacklife.habitstreak.domain.model.UserId;

import java.time.Clock;
import java.util.Objects;

public class CreateHabitService implements CreateHabitUseCase {

    private final HabitRepositoryPort habitRepositoryPort;
    private final Clock clock;

    public CreateHabitService(HabitRepositoryPort habitRepositoryPort, Clock clock) {
        this.habitRepositoryPort = Objects.requireNonNull(habitRepositoryPort, "HabitRepositoryPort es obligatorio");
        this.clock = Objects.requireNonNull(clock, "Clock es obligatorio");
    }

    @Override
    public Habit create(CreateHabitCommand command) {
        Objects.requireNonNull(command, "CreateHabitCommand es obligatorio");
        Habit habit = Habit.createNew(new UserId(command.userId()), command.name(), command.frequency(), clock);
        return habitRepositoryPort.save(habit);
    }
}
