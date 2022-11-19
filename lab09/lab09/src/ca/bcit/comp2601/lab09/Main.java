package ca.bcit.comp2601.lab09;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final String INPUT_FILE = "files\\data_lab09.csv";
//    private static final ArrayList<String> books = new ArrayList<>();
//    private static final ArrayList<Book> cars = new ArrayList<>();
    private static final int INDEX_TITLE = 0;
    private static final int INDEX_AUTHOR = 1;
    private static final int INDEX_YEAR = 2;

    public static void main(final String[] args) throws FileNotFoundException {

        // Open the courses.csv file
        File file = new File(INPUT_FILE);
        Scanner scanner = new Scanner(file);

        // Read the file
//        System.out.println(file.exists());

        while(scanner.hasNextLine()) {
            // Read a line
            String line = scanner.nextLine();
            // Split the line string into tokens
            String[] bookData = line.split(",");
//            books.add(bookData[INDEX_TITLE]);
//            books.add(bookData[INDEX_AUTHOR]);
//            books.add(bookData[INDEX_YEAR]);
//            System.out.println(bookData[INDEX_TITLE]);
            System.out.println(bookData[INDEX_TITLE]);
//            books.add()
//            String make = car[INDEX_MAKE];
//            String model = car[INDEX_MODEL];
//            int year = Integer.parseInt(car[INDEX_YEAR]);
//            boolean isElectric = Boolean.parseBoolean(car[INDEX_ELECTRIC]);
//
//            // Create an instance of Course and add to the array list
//            cars.add(new Car(make, model, year, isElectric));
        }
//        books.forEach(System.out::println);

        // Close the file
        scanner.close();
    }
}