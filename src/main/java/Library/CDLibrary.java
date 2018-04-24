package Library;

import cd.CD;
import finder.FindByTitle;
import lombok.Getter;
import track.Track;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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


    public List<Track> findTrackByTitle(String title) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
        EntityManager entityManager = entityManagerFactory.createEntityManager();


        TypedQuery<CD> select_e_from_cd_e = entityManager.createQuery("select e from CD e", CD.class);

        List<CD> resultList = select_e_from_cd_e.getResultList();

        List<Track> collect = resultList.stream()
                .flatMap(s -> s.getTrackList().stream())
                .filter(s -> s.getTitle().equals(title))
                .collect(Collectors.toList());


        entityManager.close();
        entityManagerFactory.close();

        return collect;
    }


    public List<String> findAllArist(){

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        TypedQuery<CD> select_a_from_cd_a = entityManager.createQuery("select a from CD a", CD.class);
        List<CD> resultList = select_a_from_cd_a.getResultList();

        entityManager.close();
        entityManagerFactory.close();

        List<String> collect = resultList.stream()
                .map(s -> s.getArtist())
                .collect(Collectors.toList());
     return collect;
    }
}
