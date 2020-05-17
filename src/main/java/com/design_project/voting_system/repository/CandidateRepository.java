package com.design_project.voting_system.repository;

import com.design_project.voting_system.model.Candidate;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CandidateRepository extends MongoRepository<Candidate,String> {

}
