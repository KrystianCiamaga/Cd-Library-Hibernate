package finder;

import Library.CDLibrary;

import java.util.List;

public class ArtistFinder {

    CDLibrary cdLibrary = new CDLibrary();


    public void AllArtistFinder() {
        List<String> lista = cdLibrary.findAllArist();
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(i + 1 + ": " + lista.get(i) + "\n");

        }


    }
}
