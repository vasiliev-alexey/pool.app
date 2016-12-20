package com.av.pool.app.controller;

import com.av.pool.app.domain.Vote;
import com.av.pool.app.repository.VoteRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.inject.Inject;

/**
 * Created by vasiliev-alexey on 20.12.16.
 */
@RestController
public class VoteController {

    @Inject
    private VoteRepository voteRepository;

    @RequestMapping(value = "/polls/{pollId}/votes",
            method = RequestMethod.POST)
    public ResponseEntity<?> createVote(@PathVariable Long
                                                pollId, @RequestBody Vote vote) {
        vote = voteRepository.save(vote);
        //	Set	the	headers	for	the	newly	created         resource
        HttpHeaders responseHeaders = new
                HttpHeaders();
        responseHeaders.setLocation(ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(vote.getId()).toUri());
        return new ResponseEntity<>(null,
                responseHeaders, HttpStatus.CREATED);
    }

}
