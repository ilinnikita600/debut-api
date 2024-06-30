package org.example.services;

import org.example.domain.Candidate;

public interface RegisterCandidateService {
    String signUp(Candidate candidate);
    String getCode(Candidate candidate);
    String setStatus(Candidate candidate, String code, String status);
}
