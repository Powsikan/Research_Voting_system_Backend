package com.design_project.voting_system.controller;


import com.design_project.voting_system.model.Candidate;
import com.design_project.voting_system.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    @PostMapping("/add")
    public String addCandidate(@RequestBody Candidate candidate) {
        return candidateService.addCandidate(candidate);

    }

    @GetMapping("/all")
    public List<Candidate> getCandidates() {
        return candidateService.getCandidates();
    }

    @GetMapping("all/{id}")
    public Optional<Candidate> getCandidates(@PathVariable String id) {
        return candidateService.getCandidate(id);
    }

    @DeleteMapping("delete/{id}")
    public String deleteCandidate(@PathVariable String id) {
        return candidateService.deleteCandidate(id);

    }

}