package ca.bcit.comp2601.quiz_03;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Writes commandline arguments to a file, then read this file and prints the result.
 * @author Guilherme Trevisan
 * @version 0.0.1
 * @since 2022-11-12
 */
public class Main {

    private static final String OUTPUT_FILE_NAME;

    static {
        OUTPUT_FILE_NAME = "data.txt";
    }

    /**
     * Stored cmdline arguments to a file then read the file and print content in uppercase.
     * @param args commandline arguments
     */
    public static void main(final String[] args) {
        FileWriter writer;
        FileReader reader;
        Scanner scanner;

        // Save file
        try {
            writer = new FileWriter(OUTPUT_FILE_NAME);
            for (String object : args) {
                writer.write(object + System.lineSeparator());
            }
            writer.close();
        }
        catch(IOException e) {
            System.out.println(e.getMessage());
        } finally {
            // Do nothing
        }

        // Read file
        try {
            reader = new FileReader(OUTPUT_FILE_NAME);
            scanner = new Scanner(reader);
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line.toUpperCase());
            }
        } catch(IOException e) {
            System.out.println(e.getMessage());
        } finally {
            // Do nothing
        }
    }
}