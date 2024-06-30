package org.example.services;

import lombok.AllArgsConstructor;
import org.example.domain.Candidate;
import org.example.dto.request.SetStatusRequest;
import org.example.feign.client.RegisterCandidateFeignClient;
import org.example.utils.Base64Converter;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RegisterCandidateServiceFeignImpl implements RegisterCandidateService {
    private RegisterCandidateFeignClient feignClient;

    @Override
    public String signUp(Candidate candidate) {
        return feignClient.signUp(candidate);
    }

    @Override
    public String getCode(Candidate candidate) {
        return feignClient.getCode(candidate.getEmail());
    }

    @Override
    public String setStatus(Candidate candidate, String code, String status) {
        SetStatusRequest setStatusRequest = new SetStatusRequest(Base64Converter.encodeToBase64(candidate.getEmail() + ":" + code), status);
        return feignClient.setStatus(setStatusRequest);
    }
}
