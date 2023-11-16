package com.apress.repository;
import org.springframework.data.repository.CrudRepository;
import com.apress.domain.Poll;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PollRepository extends CrudRepository<Poll, Long> {

}
