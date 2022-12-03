package ca.bcit.comp2601.assignment02;

import java.util.Scanner;

/**
 * Menu Class
 *
 * @author Guilherme Trevisan, Monika Szucs
 * @version 0.0.1
 * @since 2022-12-03
 */
public class Menu {

    private boolean exit = false;

    private void printMenu(){
        System.out.println("Type 1 for GUI");
        System.out.println("Type 2 for Streams and Filters");
        System.out.println("Type 3 for Design Patterns");
        System.out.println("Type 4 for Concurrency");
        System.out.println("Type 5 to Quit");
    }

    public void runMenu(){
        while(!exit){
            printMenu();
            int choice = getInput();
            if (choice == 1){
                exit = true;
            }
            System.out.println("Selected 1, exit");
        }
    }

    private int getInput(){
        Scanner kb = new Scanner(System.in);
        int choice = -1;
        while(choice < 0 || choice > 2){
            try {
                System.out.println("Enter your choice:");
                choice = Integer.parseInt(kb.nextLine());
            } catch(NumberFormatException e){
//                e.printStackTrace();
                System.out.println("Invalid selection. Please try again.");
            }
        }
        return choice;
    }
}
