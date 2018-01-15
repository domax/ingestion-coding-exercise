package com.dominichenko.test.domain.catalog;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
@Data @NoArgsConstructor @AllArgsConstructor
public class Products {

    @Data @NoArgsConstructor @AllArgsConstructor
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
