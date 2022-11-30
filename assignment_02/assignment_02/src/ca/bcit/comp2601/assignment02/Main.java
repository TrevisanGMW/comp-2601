package ca.bcit.comp2601.assignment02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Main
 *
 * @author Guilherme Trevisan, Monika Szucs
 * @version 0.0.1
 * @since 2022-11-28
 */

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
//        Menu m = new Menu();
//        m.runMenu();
// Open the courses.csv file
        Scanner file = new Scanner(new File("files\\countries.txt"));

        // Read the file
        while(file.hasNextLine()) {
            // Read a line
            String line = file.nextLine();

//            String[] car = line.split(",");

            System.out.println(line);
        }

        // Close the file
        file.close();

        // Create an object of CourseSearchGUI
//        CarSearchGUI app = new CarSearchGUI();

    }
}