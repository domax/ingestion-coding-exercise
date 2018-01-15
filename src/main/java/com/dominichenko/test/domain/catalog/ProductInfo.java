package com.dominichenko.test.domain.catalog;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlElement;

/**
 * @author <a href="mailto:max@dominichenko.com">Max Dominichenko</a>
 */
@SuppressWarnings("unused")
@Data @NoArgsConstructor @AllArgsConstructor
public class ProductInfo {

    private Language language;

    @XmlElement(name = "LANGUAGE", required = true)
    public void setLanguage(Language language) {
        this.language = language;
    }
}
