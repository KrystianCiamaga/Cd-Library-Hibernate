package track;

import cd.CD;

public class TrackBuilder {


    private String artist;
    private String title;

    public TrackBuilder artist(String artist) {
        this.artist = artist;
        return this;
    }

    public TrackBuilder title(String title) {
        this.title = title;
        return this;
    }


    public Track build() {

        return new Track(artist, title);
    }

}
