package com.hacklife.habitstreak.infrastructure.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hacklife.habitstreak.application.port.in.CreateHabitUseCase;
import com.hacklife.habitstreak.domain.model.Habit;
import com.hacklife.habitstreak.domain.model.HabitFrequency;
import com.hacklife.habitstreak.domain.model.HabitId;
import com.hacklife.habitstreak.domain.model.UserId;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.Instant;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HabitController.class)
@AutoConfigureMockMvc(addFilters = false)
class HabitControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private CreateHabitUseCase createHabitUseCase;

    @Test
    void shouldReturnCreatedHabit() throws Exception {
        Habit habit = new Habit(
                new HabitId(UUID.fromString("aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaaa")),
                new UserId(UUID.fromString("bbbbbbbb-bbbb-bbbb-bbbb-bbbbbbbbbbbb")),
                "Caminar 30 minutos",
                HabitFrequency.DAILY,
                Instant.parse("2026-01-01T10:00:00Z")
        );
        given(createHabitUseCase.create(any())).willReturn(habit);

        CreateHabitRequest request = new CreateHabitRequest(
                UUID.fromString("bbbbbbbb-bbbb-bbbb-bbbb-bbbbbbbbbbbb"),
                "Caminar 30 minutos",
                HabitFrequency.DAILY
        );

        mockMvc.perform(post("/api/v1/habits")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value("aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaaa"))
                .andExpect(jsonPath("$.name").value("Caminar 30 minutos"))
                .andExpect(jsonPath("$.frequency").value("DAILY"));
    }
}
