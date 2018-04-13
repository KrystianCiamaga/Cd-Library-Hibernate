package finder;

import Library.CDLibrary;
import menu.CdDisplay;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class FindByTitle {
    Scanner scanner=new Scanner(System.in);
    CDLibrary cdLibrary=new CDLibrary();




    public void findCD(){

        System.out.println("Enter CD title");
        String title=scanner.nextLine();

        CdDisplay.show(cdLibrary.findCDByTitle(title));

    }







}
