package com.dominichenko.test.domain.catalog;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author <a href="mailto:max@dominichenko.com">Max Dominichenko</a>
 */
@SuppressWarnings("unused")
@Getter @ToString @EqualsAndHashCode
public class Genre {

    private String type;
    private String genreName;

    @XmlAttribute
    public void setType(String type) {
        this.type = type;
    }

    @XmlElement(name = "GENRENAME")
    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }
}
