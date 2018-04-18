package Library;

import cd.CD;
import finder.FindByTitle;
import lombok.Getter;
import track.Track;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
public class CDLibrary {


    public void addCD(CD cd) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
        EntityManager entityManager = entityManagerFactory.createEntityManager();


        entityManager.getTransaction().begin();

        entityManager.persist(cd);

        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

    }

    public void addTracks(List<Track> tracks) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        for (Track x : tracks) {
            entityManager.persist(x);
        }

        entityManager.getTransaction().commit();


        entityManager.close();
        entityManagerFactory.close();

    }


    public List<CD> findCDByTitle(String name) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        FindByTitle findByTitle = new FindByTitle();

        TypedQuery<CD> query = entityManager.createQuery("select e from CD e where e.title=:name ", CD.class);
        query.setParameter("name", name);

        List<CD> resultList = query.getResultList();

        entityManager.close();
        entityManagerFactory.close();

        return resultList;

    }


}
