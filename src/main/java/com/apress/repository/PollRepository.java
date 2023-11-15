package com.apress.repository;
import org.springframework.data.repository.CrudRepository;
import com.apress.domain.Poll;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PollRepository extends CrudRepository<Poll, Long> {
    @Override
    default <S extends Poll> S save(S entity) {
        return null;
    }

    @Override
    default <S extends Poll> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    default Optional<Poll> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    default boolean existsById(Long aLong) {
        return false;
    }

    @Override
    default Iterable<Poll> findAll() {
        return null;
    }

    @Override
    default Iterable<Poll> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    default long count() {
        return 0;
    }

    @Override
    default void deleteById(Long aLong) {

    }

    @Override
    default void delete(Poll entity) {

    }

    @Override
    default void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    default void deleteAll(Iterable<? extends Poll> entities) {

    }

    @Override
    default void deleteAll() {

    }
}
