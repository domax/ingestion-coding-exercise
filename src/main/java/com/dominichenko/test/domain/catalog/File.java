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
public class File {

    @Getter @ToString @EqualsAndHashCode
    public static class Info {

        private String accessString;

        @XmlElement(name = "ACCESSSTRING", required = true)
        public void setAccessString(String accessString) {
            this.accessString = accessString;
        }
    }

    private String type;
    private Info info;

    @XmlAttribute
    public void setType(String type) {
        this.type = type;
    }

    @XmlElement(name = "FILEINFO", required = true)
    public void setInfo(Info info) {
        this.info = info;
    }
}
