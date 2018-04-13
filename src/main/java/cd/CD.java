package cd;


import lombok.AllArgsConstructor;
import lombok.Getter;
import track.Track;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
public class CD {

    public CD(String artist, String title, int releaseYear, List<Track> trackList) {
        this.artist = artist;
        this.title = title;
        this.releaseYear = releaseYear;
        this.trackList = trackList;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private double id;


    private String artist;
    private String title;
    private int releaseYear;


    @OneToMany
    private List<Track> trackList;


}
