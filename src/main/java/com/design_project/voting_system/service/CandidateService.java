package com.design_project.voting_system.service;


import com.design_project.voting_system.model.Candidate;
import com.design_project.voting_system.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@Service
public class CandidateService {
    @Autowired
    private CandidateRepository candidateRepository;
    @Autowired
    private FileStorageService fileStorageService;

    public String addCandidate(Candidate candidate, MultipartFile file) {
        String fileName = fileStorageService.storeFile(file);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/api/file/downloadFile/")
                .path(fileName)
                .toUriString();

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
