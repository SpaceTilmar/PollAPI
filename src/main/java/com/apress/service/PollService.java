package com.apress.service;

import com.apress.domain.Poll;
import com.apress.exception.ResourceNotFoundException;
import com.apress.repository.PollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.Optional;

@Service
public class PollService {
    @Autowired
   private PollRepository pollRepository;


    public Iterable<Poll> getAllPolls() {
        Iterable<Poll> allPolls = pollRepository.findAll();
        return allPolls;
    }

    public Poll createPoll( Poll poll) {
        return pollRepository.save(poll);
    }

    public Optional<Poll> getPoll(Long pollId) {
        return pollRepository.findById(pollId);
    }

    public Poll  updatePoll(Poll updatedPoll, Long pollId) {
        // Save the entity
        Optional<Poll> pollOptional =pollRepository.findById(pollId);
        if (pollOptional.isEmpty()) {
            throw new ResourceNotFoundException("Poll " + pollId + " id not found");
        }
        Poll existingPoll = pollOptional.get();

        existingPoll.setOptions(updatedPoll.getOptions());
        existingPoll.setQuestion(updatedPoll.getQuestion());
        pollRepository.save(existingPoll);
        return existingPoll;
    }

    public void deletePoll(Long pollId) {
        pollRepository.deleteById(pollId);
    }
}

