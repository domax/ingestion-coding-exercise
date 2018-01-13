package com.dominichenko.test.domain.catalog;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:max@dominichenko.com">Max Dominichenko</a>
 */
@SuppressWarnings("unused")
@Getter @ToString @EqualsAndHashCode
public class Track {

    private ProductInfo productInfo;
    private List<Genre> genres = new ArrayList<>();
    private List<File> files = new ArrayList<>();

    @XmlElement(name = "PRODUCTINFO", required = true)
    public void setProductInfo(ProductInfo productInfo) {
        this.productInfo = productInfo;
    }

    @XmlElementWrapper(name = "GENRES")
    @XmlElement(name = "GENRE")
    public void setGenres(List<Genre> genres) {
        this.genres = genres == null ? new ArrayList<>() : genres;
    }

    @XmlElementWrapper(name = "FILES")
    @XmlElement(name = "FILE")
    public void setFiles(List<File> files) {
        this.files = files == null ? new ArrayList<>() : files;
    }
}
