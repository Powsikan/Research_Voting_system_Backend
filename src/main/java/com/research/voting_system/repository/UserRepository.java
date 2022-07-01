package com.research.voting_system.repository;

import com.research.voting_system.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User,String> {
    User findByNicNumber(String NICnumber);
}
