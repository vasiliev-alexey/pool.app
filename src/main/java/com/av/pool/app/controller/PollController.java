package com.av.pool.app.controller;

import com.av.pool.app.domain.Poll;
import com.av.pool.app.repository.PollRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.inject.Inject;
import java.net.URI;

/**
 * Created by vasiliev-alexey on 20.12.16.
 */
@RestController
public class PollController {


    @Inject
    private PollRepository pollRepository;



    @RequestMapping(value="/polls",	method= RequestMethod.GET)
    public	ResponseEntity<Iterable<Poll>>	getAllPolls()	{
        Iterable<Poll>	allPolls	=	pollRepository.findAll();
        return	new ResponseEntity<>(pollRepository.findAll(),
                HttpStatus.OK);
    }



    @RequestMapping(value="/polls",	method=RequestMethod.POST)
    public	ResponseEntity<?>	createPoll(@RequestBody	Poll	poll)
    {
        poll	=	pollRepository.save(poll);
        //	Set	the	location	header	for	the	newly	created	        resource
        HttpHeaders	responseHeaders	=	new HttpHeaders();
        URI newPollUri	=	ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(poll.getId()).toUri();
        responseHeaders.setLocation(newPollUri);
        return	new	ResponseEntity<>(null,	responseHeaders,
                HttpStatus.CREATED);
    }

}
