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
public class Language {

    private String code;
    private String amwKey;
    private int copyrightYear;
    private String publisher;
    private boolean explicitLyrics;
    private String title;
    private int duration;
    private String copyright;
    private int trackNumber;
    private String artist;

    @XmlAttribute
    public void setCode(String code) {
        this.code = code;
    }

    @XmlElement(name="AMWKEY")
    public void setAmwKey(String amwKey) {
        this.amwKey = amwKey;
    }

    @XmlElement(name="COPYRIGHTYEAR")
    public void setCopyrightYear(int copyrightYear) {
        this.copyrightYear = copyrightYear;
    }

    @XmlElement(name="PUBLISHER")
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @XmlElement(name="EXPLICITLYRICS")
    public void setExplicitLyrics(boolean explicitLyrics) {
        this.explicitLyrics = explicitLyrics;
    }

    @XmlElement(name="TITLE")
    public void setTitle(String title) {
        this.title = title;
    }

    @XmlElement(name="DURATION")
    public void setDuration(int duration) {
        this.duration = duration;
    }

    @XmlElement(name="COPYRIGHT")
    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    @XmlElement(name="TRACKNUMBER")
    public void setTrackNumber(int trackNumber) {
        this.trackNumber = trackNumber;
    }

    @XmlElement(name="ARTIST")
    public void setArtist(String artist) {
        this.artist = artist;
    }
}
