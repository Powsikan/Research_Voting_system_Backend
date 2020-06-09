package com.design_project.voting_system.service;

import com.design_project.voting_system.model.User;
import com.design_project.voting_system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public String addUser(User user) {
        userRepository.save(user);
        return "User added";
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUser(String id) {
        return userRepository.findById(id);
    }

    public String deleteUser(String id) {
        userRepository.deleteById(id);
        return "User deleted";
    }


}

