package com.dominichenko.test.repositories;

import com.dominichenko.test.domain.Record;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.stream.Stream;

/**
 * @author <a href="mailto:max@dominichenko.com">Max Dominichenko</a>
 */
public interface RecordRepository extends CrudRepository<Record, String> {

    @Query("select r from Record r" +
            " where (?1 is null or lower(artist) like concat('%',?1,'%'))" +
            " and (?2 is null or lower(title) like concat('%',?2,'%'))")
    Stream<Record> findAllByArtistAndTitle(String artist, String title);
}
