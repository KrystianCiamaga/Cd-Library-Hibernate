import Library.CDLibrary;
import cd.CD;
import cd.CDBuilder;
import finder.FindByTitle;
import menu.CdReader;
import track.Track;
import track.TrackBuilder;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class Main {





    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        CdReader cdReader=new CdReader();


            entityManager.getTransaction().begin();

        entityManager.persist(cdReader.addNewCD());


            entityManager.getTransaction().commit();






        entityManager.close();
        entityManagerFactory.close();



    }



}
