package com.dominichenko.test.domain.catalog;

import org.junit.Test;
import org.springframework.util.ResourceUtils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author <a href="mailto:max@dominichenko.com">Max Dominichenko</a>
 */
@SuppressWarnings("SameParameterValue")
public class CatalogTest {

    @Test
    public void testUnmarshalling() throws JAXBException, FileNotFoundException {
        Products actual = (Products) JAXBContext.newInstance(Products.class).createUnmarshaller().unmarshal(
                ResourceUtils.getURL("classpath:catalog/ingestion_sample_a.xml"));

        Products expected = new Products();
        expected.setTrackBundle(new Products.TrackBundle());
        expected.getTrackBundle().setTracks(Arrays.asList(
                createTrack(
                        "all",
                        "000-SAMPLE-ABC",
                        2010,
                        "(P) 2010 Sony Music Entertainment",
                        false,
                        "The Boys of Fall",
                        392,
                        "(P) 2010 Sony Music Entertainment",
                        1,
                        "Kenny Chesney",
                        Collections.singletonList(createGenre("main", "Country")),
                        Collections.singletonList(createFile("original", "resources/000-SAMPLE-ABC.mp3"))),
                createTrack(
                        "all",
                        "000-SAMPLE-ABD",
                        2010,
                        "(P) 2010 Sony Music Entertainment",
                        false,
                        "Live a Little",
                        219,
                        "(P) 2010 Sony Music Entertainment",
                        2,
                        "Kenny Chesney",
                        Collections.singletonList(createGenre("main", "Country")),
                        Collections.singletonList(createFile("original", "resources/000-SAMPLE-ABD.mp3"))),
                createTrack(
                        "all",
                        "000-SAMPLE-ABE",
                        2010,
                        "(P) 2010 Sony Music Entertainment",
                        false,
                        "Coastal",
                        160,
                        "(P) 2010 Sony Music Entertainment",
                        3,
                        "Kenny Chesney",
                        Collections.singletonList(createGenre("main", "Country")),
                        Collections.singletonList(createFile("original", "resources/000-SAMPLE-ABE.mp3"))),
                createTrack(
                        "all",
                        "000-SAMPLE-ABF",
                        2010,
                        "(P) 2010 Sony Music Entertainment",
                        false,
                        "You and Tequila",
                        243,
                        "(P) 2010 Sony Music Entertainment",
                        4,
                        "Kenny Chesney feat. Grace Potter",
                        Collections.singletonList(createGenre("main", "Country")),
                        Collections.singletonList(createFile("original", "resources/000-SAMPLE-ABF.mp3")))
        ));
        assertEquals(expected, actual);
    }

    private Track createTrack(
            String code,
            String amwKey,
            int copyrightYear,
            String publisher,
            boolean explicitLyrics,
            String title,
            int duration,
            String copyright,
            int trackNumber,
            String artist,
            List<Genre> genres,
            List<File> files) {
        Language language = new Language();
        language.setCode(code);
        language.setAmwKey(amwKey);
        language.setCopyrightYear(copyrightYear);
        language.setPublisher(publisher);
        language.setExplicitLyrics(explicitLyrics);
        language.setTitle(title);
        language.setDuration(duration);
        language.setCopyright(copyright);
        language.setTrackNumber(trackNumber);
        language.setArtist(artist);

        ProductInfo productInfo = new ProductInfo();
        productInfo.setLanguage(language);

        Track track = new Track();
        track.setProductInfo(productInfo);
        track.setGenres(genres);
        track.setFiles(files);

        return track;
    }

    private Genre createGenre(String type, String genreName) {
        Genre genre = new Genre();
        genre.setType(type);
        genre.setGenreName(genreName);
        return genre;
    }

    private File createFile(String type, String accessString) {
        File.Info info = new File.Info();
        info.setAccessString(accessString);

        File file = new File();
        file.setType(type);
        file.setInfo(info);
        return file;
    }
}
