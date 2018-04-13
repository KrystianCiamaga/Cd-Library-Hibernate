package menu;

import Library.CDLibrary;
import cd.CD;
import cd.CDBuilder;
import lombok.Getter;
import track.Track;
import track.TrackBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Getter
public class CdReader {


    private CDLibrary cdLibrary = new CDLibrary();
    private Scanner scanner = new Scanner(System.in);
    private CD cd;


    public CD addNewCD() {

        System.out.println("Enter CD info:");
        System.out.println("Title");
        String title = scanner.nextLine();
        System.out.println("Artist");
        String artist = scanner.nextLine();
        System.out.println("Release Year");
        int releaseYear = scanner.nextInt();
        scanner.nextLine();

        cd = new CDBuilder()
                .title(title)
                .artist(artist)
                .realeaseYear(releaseYear)
                .build();
        cdLibrary.addCD(cd);

        System.out.println("Do you want add track?");
        System.out.println("Press 1 if yes");
        System.out.println("Press 2 if no");

        int option = scanner.nextInt();
        scanner.nextLine();
        if (option == 1) {
            cd.setTrackList(readTracks());
        } else {

        }


        return cd;
    }


    public List<Track> readTracks() {
        System.out.println("Enter track count");
        int count = scanner.nextInt();
        scanner.nextLine();
        List<Track> trackList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            trackList.add(readTrack());
        }
        return trackList;
    }


    public Track readTrack() {
        System.out.println("Enter Track info:");
        System.out.println("Title");
        String title = scanner.nextLine();
        System.out.println("Artist");
        String artist = scanner.nextLine();

        Track track = new TrackBuilder()
                .artist(artist)
                .title(title)
                .build();

        track.setCD(cd);
        return track;
    }


}
