package com.sky.delorean;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.LongAdder;


@Component
public class VoteStorage {

    //name of the show, dummy user id

    private Map<String, LongAdder> movieVoteCount = new ConcurrentHashMap<>();

    public void castVote(Vote movieId) {

//        movieVoteCount.computeIfAbsent(movieId, k -> new LongAdder()).increment();

    }
}
