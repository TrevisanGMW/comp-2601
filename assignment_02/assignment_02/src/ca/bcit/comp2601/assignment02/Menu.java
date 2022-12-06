package ca.bcit.comp2601.assignment02;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Menu Class
 *
 * @author Guilherme Trevisan, Monika Szucs
 * @version 0.0.1
 * @since 2022-12-03
 */
public class Menu {
    private static final int CHOICE_INITIALIZER;
    private static final int NUM_GUI;
    private static final int NUM_STREAMS;
    private static final int NUM_PATTERNS;
    private static final int NUM_CONCURRENCY;
    private static final int NUM_EXIT;
    private static final int MIN_CHOICE;
    private static final int MAX_CHOICE;
    private boolean exit = false;

    static {
        CHOICE_INITIALIZER = -1;
        NUM_GUI            = 1;
        NUM_STREAMS        = 2;
        NUM_PATTERNS       = 3;
        NUM_CONCURRENCY    = 4;
        NUM_EXIT           = 5;
        MIN_CHOICE         = NUM_GUI;
        MAX_CHOICE         = NUM_EXIT;
    }

    /**
     * Simple helper function to print the menu options
     */
    private void printMenu(){
        System.out.println("+----------------------------------+");
        System.out.println("|  Assignment 02 - Menu            |");
        System.out.println("|  Type 1 for GUI                  |");
        System.out.println("|  Type 2 for Streams and Filters  |");
        System.out.println("|  Type 3 for Design Patterns      |");
        System.out.println("|  Type 4 for Concurrency          |");
        System.out.println("|  Type 5 to Quit                  |");
        System.out.println("+----------------------------------+");
    }

    /**
     * Menu Logic (Keeps the user a loop till they quit)
     * @throws FileNotFoundException in case operations that are reading files fail to find the file
     * @throws InterruptedException is thrown when a thread is interrupted while it's waiting, sleeping...
     */
    public void runMenu() throws FileNotFoundException, InterruptedException {
        do {
            printMenu();
            int choice = getInput();
            if (choice == NUM_GUI) {
                CountryList cl = new CountryList();
            } else if (choice == NUM_STREAMS){
                CountryProcessor cp;
                cp = new CountryProcessor();
                cp.processCountries();
            } else if (choice == NUM_PATTERNS){
                Tester tester = new Tester();
                tester.test();
            } else if (choice == NUM_CONCURRENCY){
                DivideAndConquerSum.concurrentMain();
            }
            if (choice == NUM_EXIT){
                exit = true;
                System.out.println("Selected " + NUM_EXIT + ", exiting...");
            }
        }while(!exit);
    }

    /**
     * Gets the user input - Repeats question till a valid number is achieved.
     * @return a valid choice number between MIN_CHOICE and MAX_CHOICE (inclusive)
     */
    private int getInput(){
        Scanner kb = new Scanner(System.in);
        String errorMessage ="Invalid selection. Please try again.";
        int choice = CHOICE_INITIALIZER;
        while(choice < MIN_CHOICE || choice > MAX_CHOICE){
            try {
                System.out.println("Enter your choice:");
                choice = Integer.parseInt(kb.nextLine());
                if (choice < MIN_CHOICE || choice > MAX_CHOICE){
                    System.out.println(errorMessage);
                }
            } catch(NumberFormatException e){
                // e.printStackTrace();
                System.out.println(errorMessage);
            }
        }
        return choice;
    }
}
