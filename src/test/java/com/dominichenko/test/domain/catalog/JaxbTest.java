package com.dominichenko.test.domain.catalog;

import org.junit.Test;
import org.springframework.util.ResourceUtils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

/**
 * @author <a href="mailto:max@dominichenko.com">Max Dominichenko</a>
 */
public class JaxbTest {

    @Test
    public void testUnmarshalling() throws JAXBException, FileNotFoundException {
        Products products = (Products) JAXBContext.newInstance(Products.class).createUnmarshaller().unmarshal(
                ResourceUtils.getURL("classpath:catalog/ingestion_sample_a.xml"));
        System.out.println(products);
    }
}
