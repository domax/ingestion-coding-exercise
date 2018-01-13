package com.dominichenko.test.domain.catalog;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:max@dominichenko.com">Max Dominichenko</a>
 */
@SuppressWarnings("unused")
@XmlRootElement(name = "PRODUCTS")
@Getter @ToString @EqualsAndHashCode
public class Products {

    @Getter @ToString @EqualsAndHashCode
    public static class TrackBundle {

        private List<Track> tracks = new ArrayList<>();

        @XmlElementWrapper(name = "TRACKS")
        @XmlElement(name = "TRACK")
        public void setTracks(List<Track> tracks) {
            this.tracks = tracks == null ? new ArrayList<>() : tracks;
        }
    }

    private TrackBundle trackBundle;

    @XmlElement(name = "TRACKBUNDLE", required = true)
    public void setTrackBundle(TrackBundle trackBundle) {
        this.trackBundle = trackBundle;
    }
}
