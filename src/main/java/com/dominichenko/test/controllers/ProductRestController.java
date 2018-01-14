package com.dominichenko.test.controllers;

import com.dominichenko.test.domain.Record;
import com.dominichenko.test.domain.catalog.Genre;
import com.dominichenko.test.domain.catalog.Language;
import com.dominichenko.test.domain.catalog.Products;
import com.dominichenko.test.repositories.RecordRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.util.StringUtils.hasText;

/**
 * @author <a href="mailto:max@dominichenko.com">Max Dominichenko</a>
 */
@Slf4j
@RestController
@RequestMapping(path = "/api")
public class ProductRestController {

    private final RecordRepository recordRepository;

    @Autowired
    public ProductRestController(RecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }

    @Transactional
    @PostMapping(consumes = MediaType.APPLICATION_XML_VALUE)
    void ingestProductsXml(@RequestBody Products products) {
        log.info("ingestProductsXml");
        log.debug("{}", products);
        products.getTrackBundle().getTracks().forEach(t -> {
            Record r = new Record();
            Language l = t.getProductInfo().getLanguage();
            r.setAmwKey(l.getAmwKey());
            r.setLanguageCode(l.getCode());
            r.setCopyrightYear(l.getCopyrightYear());
            r.setPublisher(l.getPublisher());
            r.setExplicitLyrics(l.isExplicitLyrics());
            r.setTitle(l.getTitle());
            r.setDuration(l.getDuration());
            r.setCopyright(l.getCopyright());
            r.setTrackNumber(l.getTrackNumber());
            r.setArtist(l.getArtist());
            r.setGenres(t.getGenres().stream().map(Genre::getGenreName).toArray(String[]::new));
            r.setFiles(t.getFiles().stream().map(f -> f.getInfo().getAccessString()).toArray(String[]::new));
            recordRepository.save(r);
        });
    }

    @Transactional
    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public List<Record> searchRecords(
            @RequestParam(name = "a", required = false) String artist,
            @RequestParam(name = "t", required = false) String title,
            @RequestParam(name = "g", required = false) String genre) {
        log.info("searchRecords: artist={}, title={}, genre={}", artist, title, genre);

        final String gn = hasText(genre) ? genre.toLowerCase() : null;
        List<Record> result = recordRepository.findAllByArtistAndTitle(
                hasText(artist) ? artist.toLowerCase() : null,
                hasText(title) ? title.toLowerCase() : null)
                .filter(r -> gn == null ||
                        r.getGenres() != null && Arrays.stream(r.getGenres())
                                .map(String::toLowerCase)
                                .anyMatch(g -> g.contains(gn)))
                .collect(Collectors.toList());

        log.info("searchRecords: {} records found", result.size());
        return result;
    }
}
