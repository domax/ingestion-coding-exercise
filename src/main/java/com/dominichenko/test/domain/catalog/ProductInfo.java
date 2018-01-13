package com.dominichenko.test.domain.catalog;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlElement;

/**
 * @author <a href="mailto:max@dominichenko.com">Max Dominichenko</a>
 */
@SuppressWarnings("unused")
@Getter @ToString @EqualsAndHashCode
public class ProductInfo {

    private Language language;

    @XmlElement(name = "LANGUAGE", required = true)
    public void setLanguage(Language language) {
        this.language = language;
    }
}
