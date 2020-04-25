package com.design_project.voting_system.controller;

import com.design_project.voting_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")

@RestController
public class VotingController {

    @Autowired
    UserService userService;

    @ResponseBody
    @RequestMapping("/NICValidation")
    public Object validateNIC(@RequestParam String NICnumber) {
        return userService.validateNIC(NICnumber);

    }

    @ResponseBody
    @RequestMapping("/FingerPrintValidation")
    public Object validateFingerPrint(@RequestParam String NICnumber, @RequestParam String fingerPrint) {
        return userService.validateFingerPrint(NICnumber, fingerPrint);

    }
}
