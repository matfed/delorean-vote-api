package com.sky.delorean;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class VoteService {

    public static final String MESSAGE_INVALID_DATA_SENT = "{\"message\": \"invalid data sent\"}";
    public static final String VOTE_ACCEPTED = "{\"message\": \"vote has been cast\"}";

    private final VoteStorage voteStorage;

    @Autowired
    public VoteService(VoteStorage voteStorage) {
        this.voteStorage = voteStorage;
    }

    public ResponseEntity<String> castVote(Vote vote) {
        return isValidVote(vote) ? addVoteForMovie(vote) : new ResponseEntity<>(MESSAGE_INVALID_DATA_SENT, HttpStatus.BAD_REQUEST);
    }

    private ResponseEntity<String> addVoteForMovie(Vote vote) {
        voteStorage.castVote(vote);
        return new ResponseEntity<String>(VOTE_ACCEPTED, HttpStatus.ACCEPTED);
    }

    private boolean isValidVote(Vote vote) {
        return (vote != null && vote.getProgrammeId() != null && vote.getUsername() != null);
    }
}
