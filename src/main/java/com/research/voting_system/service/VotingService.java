package com.research.voting_system.service;

import com.research.voting_system.model.Candidate;
import com.research.voting_system.model.User;
import com.research.voting_system.repository.CandidateRepository;
import com.research.voting_system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ResponseBody;


@CrossOrigin(origins = "*", allowedHeaders = "*")

@Service
public class VotingService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CandidateRepository candidateRepository;

    @ResponseBody
    public Object validateNIC(String NICnumber) {
        User user = userRepository.findByNicNumber(NICnumber);
        if (user != null) {
            if (!user.isHasVoted()) {

                return new ResponseEntity(user, HttpStatus.OK);
            } else {
                return new ResponseEntity("Already voted", HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity("You are not eligible for vote", HttpStatus.NOT_FOUND);
        }

    }

    public Object validateFingerPrint(String NICnumber, String fingerPrint) {
        User user = userRepository.findByNicNumber(NICnumber);

        if (fingerPrint.equals(user.getFingerPrint())) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity("Finger print doesn't match", HttpStatus.BAD_REQUEST);
        }
    }

    public Object performVoting(String NICnumber, String id) {
        User user = userRepository.findByNicNumber(NICnumber);
        if (user.isHasVoted() == true) {
            return new ResponseEntity("You Already Voted.", HttpStatus.BAD_REQUEST);
        }

        Candidate candidate = candidateRepository.findById(id).get();
        candidate.setTotal_votes(candidate.getTotal_votes() + 1);
        candidateRepository.save(candidate);
        user.setHasVoted(true);
        userRepository.save(user);
        return "voting succeeded";

    }
}
