package com.design_project.voting_system.controller;


import com.design_project.voting_system.model.User;
import com.design_project.voting_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public String addUser(@RequestBody User user) {
        return userService.addUser(user);

    }

    @GetMapping("/allUsers")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("allUsers/{id}")
    public Optional<User> getUser(@PathVariable String id) {
        return userService.getUser(id);
    }

    @DeleteMapping("delete/{id}")
    public String deleteUser(@PathVariable String id) {
        return userService.deleteUser(id);

    }
}
