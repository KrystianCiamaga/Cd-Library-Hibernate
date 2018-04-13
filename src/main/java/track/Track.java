package track;

import cd.CD;
import lombok.Getter;

import javax.persistence.*;
import java.util.Set;


@Entity
@Getter
public class Track {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;
    private String artist;

    @ManyToOne
    private CD cd;


    public Track() {
    }

    public Track(String title, String artist) {
        this.title = title;
        this.artist = artist;

    }

    public void setCD(CD cd) {
        this.cd = cd;
    }

    @Override
    public String toString() {
        return "Track{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", cd=" + cd +
                '}';
    }
}
