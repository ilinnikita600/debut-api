package org.example.controllers;

import org.assertj.core.api.Assertions;
import org.example.domain.Candidate;
import org.example.domain.Role;
import org.example.services.RegisterCandidateService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class CandidateControllerTest {
    private RegisterCandidateService registerCandidateService;
    private CandidateController candidateController;

    @BeforeEach
    void setUp() {
        registerCandidateService = mock();
        candidateController = new CandidateController(registerCandidateService);
        when(registerCandidateService.signUp(any())).thenReturn("Данные внесены");
        when(registerCandidateService.getCode(any())).thenReturn("some code");
        when(registerCandidateService.setStatus(any(), any(), any())).thenReturn("status increased установлен");
    }

    @Test
    void registerCandidate() {
        Candidate candidate = new Candidate("Тест", "Тестов", "test@test.test", Role.TESTER);

        String response = candidateController.registerCandidate(candidate);

        verify(registerCandidateService).getCode(candidate);
        verify(registerCandidateService).signUp(candidate);
        verify(registerCandidateService).setStatus(candidate, "some code","increased");
        Assertions.assertThat(response).isEqualTo("Данные внесены\nsome code\nstatus increased установлен");
    }
}