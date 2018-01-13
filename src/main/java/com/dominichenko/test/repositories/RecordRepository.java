package com.dominichenko.test.repositories;

import com.dominichenko.test.domain.Record;
import org.springframework.data.repository.CrudRepository;

/**
 * @author <a href="mailto:max@dominichenko.com">Max Dominichenko</a>
 */
public interface RecordRepository extends CrudRepository<Record, String> {

    Iterable<Record> findRecordsByArtistContainingIgnoreCase(String artist);

    Iterable<Record> findRecordsByTitleContainingIgnoreCase(String title);

    Iterable<Record> findRecordsByArtistContainingIgnoreCaseAndTitleContainingIgnoreCase(String artist, String title);
}
