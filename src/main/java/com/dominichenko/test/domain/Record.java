package com.dominichenko.test.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

/**
 * @author <a href="mailto:max@dominichenko.com">Max Dominichenko</a>
 */
@Entity
@Data
public class Record {
    @Column @Id private String amwKey;
    @Column private String languageCode;
    @Column private int copyrightYear;
    @Column private String publisher;
    @Column private boolean explicitLyrics;
    @Column private String title;
    @Column private int duration;
    @Column private String copyright;
    @Column private int trackNumber;
    @Column private String artist;
    @Column private String[] genres;
    @Column private String[] files;
}
