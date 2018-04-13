package Library;

import cd.CD;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
public class CDLibrary {



private List<CD> cdList=new ArrayList<>();


public void addCD(CD cd){
    cdList.add(cd);
}



public List<CD> findCDByTitle(String name){

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    TypedQuery<CD> query = entityManager.createQuery("select e from CD e where e.title=:name ", CD.class);
    query.setParameter("name",name);

    List<CD> resultList = query.getResultList();

    entityManager.close();
    entityManagerFactory.close();


   return resultList;

}




}
