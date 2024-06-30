package org.example.feign.client;

import org.example.config.feign.RegisterCandidateConfig;
import org.example.domain.Candidate;
import org.example.dto.request.SetStatusRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value = "registerCandidate", url = "${feign.register-candidate.url}", configuration = RegisterCandidateConfig.class)
public interface RegisterCandidateFeignClient {

    @PostMapping(value = "/api/sign-up/", produces = MediaType.TEXT_PLAIN_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    String signUp(Candidate candidate);

    @GetMapping(value = "/api/get-code/?email={email}", produces = MediaType.TEXT_PLAIN_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    String getCode(@PathVariable String email);

    @PostMapping(value = "/api/set-status/", produces = MediaType.TEXT_PLAIN_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    String setStatus(SetStatusRequest request);
}
