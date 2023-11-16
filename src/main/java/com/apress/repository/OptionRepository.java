package com.apress.repository;

import com.apress.domain.PollOption;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OptionRepository extends CrudRepository<PollOption, Long> {

}