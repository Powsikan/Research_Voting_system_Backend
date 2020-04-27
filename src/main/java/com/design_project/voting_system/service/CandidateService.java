package com.design_project.voting_system.service;


import com.design_project.voting_system.model.Candidate;
import com.design_project.voting_system.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CandidateService {
    @Autowired
    private CandidateRepository candidateRepository;


    public String addCandidate(Candidate candidate) {
        candidateRepository.save(candidate);
        return "Candidate added";
    }

    public List<Candidate> getCandidates() {
        return candidateRepository.findAll();
    }

    public Optional<Candidate> getCandidate(String id) {
        return candidateRepository.findById(id);
    }

    public String deleteCandidate(String id) {
        candidateRepository.deleteById(id);
        return "Candidate deleted";
    }
}
