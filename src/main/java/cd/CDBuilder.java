package cd;

import track.Track;

import java.util.ArrayList;
import java.util.List;

public class CDBuilder {


    private String artist;
    private String title;
    private int releaseYear;
    private List<Track> trackList = new ArrayList<>();
    private CD cd;



    public CDBuilder artist(String artist) {
        this.artist = artist;
        return this;
    }

    public CDBuilder title(String title) {
        this.title = title;
        return this;
    }

    public CDBuilder realeaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
        return this;
    }

    public CDBuilder trackList(List<Track> list) {
        this.trackList.addAll(list);
        return this;
    }

    public CDBuilder setOneTrack(Track track) {
        track.setCD(this.cd);
        this.trackList.add(track);
        return this;
    }


    public CD build() {
        cd=new CD(artist,title,releaseYear,trackList);
        return cd;
    }


}
