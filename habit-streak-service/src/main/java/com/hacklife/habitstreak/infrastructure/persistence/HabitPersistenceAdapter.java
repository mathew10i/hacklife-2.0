package com.hacklife.habitstreak.infrastructure.persistence;

import com.hacklife.habitstreak.application.port.out.HabitRepositoryPort;
import com.hacklife.habitstreak.domain.model.Habit;
import com.hacklife.habitstreak.domain.model.HabitId;
import com.hacklife.habitstreak.domain.model.UserId;
import org.springframework.stereotype.Component;

@Component
public class HabitPersistenceAdapter implements HabitRepositoryPort {

    private final SpringDataHabitRepository springDataHabitRepository;

    public HabitPersistenceAdapter(SpringDataHabitRepository springDataHabitRepository) {
        this.springDataHabitRepository = springDataHabitRepository;
    }

    @Override
    public Habit save(Habit habit) {
        HabitJpaEntity entity = new HabitJpaEntity(
                habit.id().value(),
                habit.userId().value(),
                habit.name(),
                habit.frequency(),
                habit.createdAt()
        );
        HabitJpaEntity savedEntity = springDataHabitRepository.save(entity);
        return new Habit(
                new HabitId(savedEntity.getId()),
                new UserId(savedEntity.getUserId()),
                savedEntity.getName(),
                savedEntity.getFrequency(),
                savedEntity.getCreatedAt()
        );
    }
}
