package com.sky.delorean;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class VoteResource {

    private final VoteService voteService;

    @Autowired
    public VoteResource(VoteService voteService) {
        this.voteService = voteService;
    }

    @RequestMapping(value = "/delorean/vote", method = POST, produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity helloWorld(@RequestBody Vote vote) {
        return voteService.castVote(vote);
    }
}
