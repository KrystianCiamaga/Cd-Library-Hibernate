package menu;

import cd.CD;
import track.Track;

import java.util.List;

public class CdDisplay {


    public static void show(List<CD> list) {
        int i=1;
        for (CD cd : list) {
            System.out.println(cd.toString());
            for (Track track : cd.getTrackList()) {
                System.out.println("Track: "+i);
                System.out.println("Title: " + track.getTitle());
                System.out.println("Artist: " + track.getArtist()+"\n");

                i++;
            }
        }
    }
}
