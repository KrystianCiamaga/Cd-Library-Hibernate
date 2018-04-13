package cd;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import track.Track;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class CD {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String artist;
    private String title;
    private int releaseYear;

    @OneToMany(mappedBy = "cd")
    private List<Track> trackList;

    public CD(String artist, String title, int releaseYear, List trackList) {
        this.artist = artist;
        this.title = title;
        this.releaseYear = releaseYear;
        this.trackList = trackList;
    }







}
