package Library;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.text.html.parser.Entity;

public class Main {


    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
        EntityManager entityManager = entityManagerFactory.createEntityManager();



        CD cd=new CD("lala");



        entityManager.getTransaction().begin();


        entityManager.persist(cd);

        entityManager.getTransaction().commit();








        entityManager.close();
        entityManagerFactory.close();


    }



}
