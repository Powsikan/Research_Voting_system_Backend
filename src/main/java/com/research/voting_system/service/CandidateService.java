package com.research.voting_system.service;


import com.research.voting_system.model.Candidate;
import com.research.voting_system.repository.CandidateRepository;
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

    public String addCandidate( MultipartFile file,Candidate newCandidate) {
        String fileName = fileStorageService.storeFile(file);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("candidate/uploads/")
                .path(fileName)
                .toUriString();

        Candidate candidate=new Candidate();

        candidate.setName(newCandidate.getName());
        candidate.setParty(newCandidate.getParty());
        candidate.setSymbol(fileDownloadUri);
        candidate.setNo_of_votes_ele_vol(newCandidate.getNo_of_votes_ele_vol());
        candidate.setNo_of_votes_ele_dist(newCandidate.getNo_of_votes_ele_dist());
        candidate.setTotal_votes(newCandidate.getTotal_votes());
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
