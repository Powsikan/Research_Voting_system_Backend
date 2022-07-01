package com.research.voting_system.repository;

import com.research.voting_system.model.Candidate;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CandidateRepository extends MongoRepository<Candidate,String> {

}
