package com.dominichenko.test.domain.catalog;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author <a href="mailto:max@dominichenko.com">Max Dominichenko</a>
 */
@SuppressWarnings("unused")
@Data @NoArgsConstructor @AllArgsConstructor
public class Genre {

    private String type;
    private String genreName;

    @XmlAttribute
    public void setType(String type) {
        this.type = type;
    }

    @XmlElement(name = "GENRENAME", required = true)
    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }
}
