package cd;

import Library.CDLibrary;
import finder.FindByTitle;
import menu.CdReader;

import java.util.Scanner;

public class App {
    Scanner scanner = new Scanner(System.in);
    CdReader cdReader = new CdReader();
    CDLibrary cdLibrary = new CDLibrary();
    FindByTitle findByTitle = new FindByTitle();


    public void showMenu() {
        boolean exit = false;
        while (!exit) {
            System.out.println("Main menu:");
            System.out.println("1. Add new CD");
            System.out.println("2. Show all CDs");
            System.out.println("3. Find CDs by artist");
            System.out.println("4. Show all artists");
            System.out.println("5. Find CDs by title");
            System.out.println("5. Find tracks by title");
            System.out.println("6. Exit");
            int option = Integer.parseInt(scanner.nextLine());
            switch (option) {
                case 1:
                    cdReader.addNewCD();
                    break;
                case 3:
                    findByTitle.findCD();
                default:
                    exit = true;
            }
        }


    }


    public static void main(String[] args) {

        App app=new App();

        app.showMenu();


    }


}
