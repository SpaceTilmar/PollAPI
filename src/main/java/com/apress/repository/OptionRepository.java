package com.apress.repository;

import com.apress.domain.PollOption;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OptionRepository extends CrudRepository<PollOption, Long> {
    @Override
    default <S extends PollOption> S save(S entity) {
        return null;
    }

    @Override
    default <S extends PollOption> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    default Optional<PollOption> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    default boolean existsById(Long aLong) {
        return false;
    }

    @Override
    default Iterable<PollOption> findAll() {
        return null;
    }

    @Override
    default Iterable<PollOption> findAllById(Iterable<Long> longs) {
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
    default void delete(PollOption entity) {

    }

    @Override
    default void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    default void deleteAll(Iterable<? extends PollOption> entities) {

    }

    @Override
    default void deleteAll() {

    }
}