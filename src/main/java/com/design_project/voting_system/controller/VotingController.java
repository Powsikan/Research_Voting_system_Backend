package com.design_project.voting_system.controller;

import com.design_project.voting_system.service.VotingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")

@RestController
@RequestMapping("/vote")
public class VotingController {

    @Autowired
    private VotingService votingService;

    @ResponseBody
    @RequestMapping("/NICValidation/{NICnumber}")
    public Object validateNIC(@PathVariable String NICnumber) {
        return votingService.validateNIC(NICnumber);

    }

    @ResponseBody
    @RequestMapping("/FingerPrintValidation/{NICnumber}")
    public Object validateFingerPrint(@PathVariable String NICnumber, @RequestParam String fingerPrint) {
        return votingService.validateFingerPrint(NICnumber, fingerPrint);

    }

    @PostMapping
    public Object performVoting(){
        return 1;
    }
}
