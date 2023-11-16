package com.apress.controller;


import com.apress.domain.Poll;
import com.apress.exception.ResourceNotFoundException;
import com.apress.service.PollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.apress.repository.PollRepository;
import org.springframework.web.servlet.support.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
public class PollController {
    @Autowired
    private PollService pollService;

    @GetMapping("/polls")
    public ResponseEntity<Iterable<Poll>> getAllPolls() {
        Iterable<Poll> allPolls = pollService.getAllPolls();
        return new ResponseEntity<>(allPolls, HttpStatus.OK);
    }

    @PostMapping(value="/polls")
    public ResponseEntity<?> createPoll(@Valid @RequestBody Poll poll) {
       poll = pollService.createPoll(poll);

        // Set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newPollUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}").buildAndExpand(poll.getId()).toUri();
        responseHeaders.setLocation(newPollUri);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    protected void verifyPoll(Long pollId) throws ResourceNotFoundException {
        Optional<Poll> poll = pollService.getPoll(pollId);
        if (poll == null) {
            throw new ResourceNotFoundException("Poll with id " + pollId + " not found");
        }
    }

    @GetMapping(value = "/polls/{pollId}")
    public ResponseEntity<?> getPoll(@PathVariable Long pollId) {
        verifyPoll(pollId);
        Optional<Poll> p = pollService.getPoll(pollId);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @PutMapping(value = "/polls/{pollId}")
    public ResponseEntity<?> updatePoll(@RequestBody Poll poll, @PathVariable Long pollId) {
        verifyPoll(pollId);
        pollService.updatePoll(poll,pollId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/polls/{pollId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deletePoll(@PathVariable Long pollId) {
        verifyPoll(pollId);
        pollService.deletePoll(pollId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}