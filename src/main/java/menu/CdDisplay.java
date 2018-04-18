package menu;

import cd.CD;
import track.Track;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class CdDisplay {


    public static void show(List<CD> list) {
        int i = 1;
        for (CD cd : list) {
            System.out.println(cd.toString());
            for (Track track : cd.getTrackList()) {
                System.out.println("Track: " + i);
                System.out.println("Title: " + track.getTitle());
                System.out.println("Artist: " + track.getArtist() + "\n");

                i++;
            }
        }
    }


    public static void show() {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
        EntityManager entityManager = entityManagerFactory.createEntityManager();


        Query query = entityManager.createQuery("select e from CD e", CD.class);
        List<CD> resultList = query.getResultList();


        int i = 1;
        for (CD cd : resultList) {
            System.out.println("------------------------");
            System.out.println(cd.toString() + "\n");
            for (Track track : cd.getTrackList()) {
                System.out.println("Track: " + i);
                System.out.println("Title: " + track.getTitle());
                System.out.println("Artist: " + track.getArtist() + "\n");

                i++;
            }
            i = 1;
        }

        entityManager.close();
        entityManagerFactory.close();

    }







}
