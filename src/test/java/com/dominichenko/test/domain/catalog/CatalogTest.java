package com.dominichenko.test.domain.catalog;

import org.junit.Test;
import org.springframework.util.ResourceUtils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

/**
 * @author <a href="mailto:max@dominichenko.com">Max Dominichenko</a>
 */
public class CatalogTest {

    @Test
    public void testUnmarshalling() throws JAXBException, FileNotFoundException {
        Products actual = (Products) JAXBContext.newInstance(Products.class).createUnmarshaller().unmarshal(
                ResourceUtils.getURL("classpath:catalog/ingestion_sample_a.xml"));

        Products expected = new Products(new Products.TrackBundle(Arrays.asList(
                new Track(new ProductInfo(new Language(
                        "all",
                        "000-SAMPLE-ABC",
                        2010,
                        "(P) 2010 Sony Music Entertainment",
                        false,
                        "The Boys of Fall",
                        392,
                        "(P) 2010 Sony Music Entertainment",
                        1,
                        "Kenny Chesney")),
                        Collections.singletonList(new Genre("main", "Country")),
                        Collections.singletonList(new File("original",
                                new File.Info("resources/000-SAMPLE-ABC.mp3")))),
                new Track(new ProductInfo(new Language(
                        "all",
                        "000-SAMPLE-ABD",
                        2010,
                        "(P) 2010 Sony Music Entertainment",
                        false,
                        "Live a Little",
                        219,
                        "(P) 2010 Sony Music Entertainment",
                        2,
                        "Kenny Chesney")),
                        Collections.singletonList(new Genre("main", "Country")),
                        Collections.singletonList(new File("original",
                                new File.Info("resources/000-SAMPLE-ABD.mp3")))),
                new Track(new ProductInfo(new Language(
                        "all",
                        "000-SAMPLE-ABE",
                        2010,
                        "(P) 2010 Sony Music Entertainment",
                        false,
                        "Coastal",
                        160,
                        "(P) 2010 Sony Music Entertainment",
                        3,
                        "Kenny Chesney")),
                        Collections.singletonList(new Genre("main", "Country")),
                        Collections.singletonList(new File("original",
                                new File.Info("resources/000-SAMPLE-ABE.mp3")))),
                new Track(new ProductInfo(new Language(
                        "all",
                        "000-SAMPLE-ABF",
                        2010,
                        "(P) 2010 Sony Music Entertainment",
                        false,
                        "You and Tequila",
                        243,
                        "(P) 2010 Sony Music Entertainment",
                        4,
                        "Kenny Chesney feat. Grace Potter")),
                        Collections.singletonList(new Genre("main", "Country")),
                        Collections.singletonList(new File("original",
                                new File.Info("resources/000-SAMPLE-ABF.mp3"))))
        )));
        assertEquals(expected, actual);
    }
}
