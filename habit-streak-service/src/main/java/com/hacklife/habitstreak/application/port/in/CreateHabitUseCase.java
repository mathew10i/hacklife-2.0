package com.hacklife.habitstreak.application.port.in;

import com.hacklife.habitstreak.application.command.CreateHabitCommand;
import com.hacklife.habitstreak.domain.model.Habit;

public interface CreateHabitUseCase {

    Habit create(CreateHabitCommand command);
}
