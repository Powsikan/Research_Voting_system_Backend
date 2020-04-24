package com.design_project.voting_system.repository;

import com.design_project.voting_system.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,String> {
}
