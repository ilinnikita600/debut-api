package org.example.controllers;

import lombok.RequiredArgsConstructor;
import org.example.domain.Candidate;
import org.example.services.RegisterCandidateService;
import org.example.utils.ResponseFormatter;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/candidate")
@RequiredArgsConstructor
public class CandidateController {

    private final RegisterCandidateService registerCandidateService;

    @PostMapping(path = "/register", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String registerCandidate(@RequestBody Candidate candidate) {
        StringBuilder response = new StringBuilder();
        String signUpResponse = ResponseFormatter.removeEndQuotesAndLeadingSpaces(registerCandidateService.signUp(candidate));
        response.append(signUpResponse).append("\n");
        String code = ResponseFormatter.removeEndQuotesAndLeadingSpaces(registerCandidateService.getCode(candidate));
        response.append(code).append("\n");
        String setStatusResponse = ResponseFormatter.removeEndQuotesAndLeadingSpaces(registerCandidateService.setStatus(candidate, code, "increased"));
        response.append(setStatusResponse);
        return response.toString();
    }
}
