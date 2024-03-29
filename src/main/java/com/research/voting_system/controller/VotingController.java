package com.research.voting_system.controller;

import com.research.voting_system.service.VotingService;
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

    @PostMapping("/votefor/{NICnumber}")
    public Object performVoting(@PathVariable String NICnumber , @RequestParam String id){
        return votingService.performVoting(NICnumber,id);
    }
}
