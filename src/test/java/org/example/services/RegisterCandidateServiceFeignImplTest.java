package org.example.services;

import org.assertj.core.api.Assertions;
import org.example.domain.Candidate;
import org.example.domain.Role;
import org.example.dto.request.SetStatusRequest;
import org.example.feign.client.RegisterCandidateFeignClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.http.HttpEntity;

import java.util.stream.Stream;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class RegisterCandidateServiceFeignImplTest {
    @Mock
    private RegisterCandidateFeignClient feignClient;
    @InjectMocks
    private RegisterCandidateService registerCandidateService = new RegisterCandidateServiceFeignImpl( null);
    @Captor
    private ArgumentCaptor<SetStatusRequest> setStatusRequestArgumentCaptor;
    @Captor
    private ArgumentCaptor<HttpEntity<SetStatusRequest>> entityWithSetStatusRequestCaptor;

    @BeforeEach
    public void setUp() {
        when(feignClient.getCode(any())).thenReturn("test answer");
        when(feignClient.signUp(any())).thenReturn("test answer");
        when(feignClient.setStatus(any())).thenReturn("test answer");
    }

    @Test
    public void signUp() {
        Candidate candidate = new Candidate("Тест", "Тестов", "test@test.test", Role.TESTER);

        String response = registerCandidateService.signUp(candidate);

        verify(feignClient).signUp(candidate);
        Assertions.assertThat(response).isEqualTo("test answer");
    }

    @Test
    public void getCode() {
        Candidate candidate = new Candidate("Тест", "Тестов", "test@test.test", Role.TESTER);

        String response = registerCandidateService.getCode(candidate);

        verify(feignClient).getCode(candidate.getEmail());
        Assertions.assertThat(response).isEqualTo("test answer");
    }

    @Test
    public void setStatus() {
        Candidate candidate = new Candidate("Тест", "Тестов", "test@test.test", Role.TESTER);
        String code = "code52";
        String status = "increased";

        String response = registerCandidateService.setStatus(candidate, code, status);

        verify(feignClient).setStatus(setStatusRequestArgumentCaptor.capture());
        SetStatusRequest request = setStatusRequestArgumentCaptor.getValue();
        Assertions.assertThat(request.getToken()).isEqualTo("dGVzdEB0ZXN0LnRlc3Q6Y29kZTUy");
        Assertions.assertThat(request.getStatus()).isEqualTo("increased");
        Assertions.assertThat(response).isEqualTo("test answer");
    }
}