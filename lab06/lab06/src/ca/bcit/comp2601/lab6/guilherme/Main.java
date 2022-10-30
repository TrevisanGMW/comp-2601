package ca.bcit.comp2601.lab6.guilherme;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


/**
 * Main Class - Program Entry Point
 */
public class Main {
    private static final int NO_ARGUMENTS_LENGTH;
    private static final int FIRST_ARGUMENT_INDEX;
    private static final int MIN_OUTPUT_FILE_CHAR_LENGTH;
    private static final int EXIT_CODE_FAILURE;
    private static final int FIRST_ELEMENT;
    private static final int MIN_SPLIT_LENGTH;
    private static final String TEXT_FILE_EXTENSION;
    private static final String FILE_FIRST_NAMES;
    private static final String FILE_FULL_NAMES;
    private static final String SPLIT_SPACE_REGEX;
    private static final String NEW_LINE_SYMBOL;

    static {
        NO_ARGUMENTS_LENGTH = 0;
        FIRST_ARGUMENT_INDEX = 0;
        MIN_OUTPUT_FILE_CHAR_LENGTH = 20;
        EXIT_CODE_FAILURE = 0;
        FIRST_ELEMENT = 0;
        MIN_SPLIT_LENGTH = 0;
        TEXT_FILE_EXTENSION = ".txt";
        FILE_FIRST_NAMES = "firstnames.txt";
        FILE_FULL_NAMES = "fullnames.txt";
        SPLIT_SPACE_REGEX = "\\s+";
        NEW_LINE_SYMBOL = "\n";
    }

    /**
     * Main Method
     * @param args commandline arguments (expects at least one string)
     */
    public static void main(final String[] args) {
        // Checked
        try{
            validateArguments(args);
        } catch (MissingFileName e) {
            System.out.println(e.getMessage());
            System.exit(EXIT_CODE_FAILURE);
        } finally {
            // Do nothing
        }

        // Unchecked
        String outputFilename;
        outputFilename = validateFileName(args[FIRST_ARGUMENT_INDEX]);

        FileReader reader;
        FileWriter writer;
        Scanner scanner;
        Set<String> firstNames;
        firstNames = new HashSet<>();

        // Store String with Full Names
        StringBuilder fullNamesString;
        fullNamesString = new StringBuilder();
        try
        {
            reader = new FileReader(FILE_FULL_NAMES);
            scanner = new Scanner(reader);
            while(scanner.hasNextLine())
            {
                String line = scanner.nextLine();
                String[] lineSplit;
                lineSplit = line.trim().split(SPLIT_SPACE_REGEX);
                if (lineSplit.length > MIN_SPLIT_LENGTH){
                    fullNamesString.append(lineSplit[FIRST_ELEMENT] + NEW_LINE_SYMBOL);
                } // Only include first names
            }
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        } finally {
            // Do nothing
        }

        // Handle Firstnames.txt
        try
        {
            reader = new FileReader(FILE_FIRST_NAMES);
            scanner = new Scanner(reader);
            while(scanner.hasNextLine())
            {
                String line = scanner.nextLine();
                if (fullNamesString.toString().contains(line)) {
                    firstNames.add(line);
                } // Name is also present in full names file
                writer = new FileWriter(line + TEXT_FILE_EXTENSION);
                for (int i = FIRST_ELEMENT; i < line.length(); i++) {
                    writer.write(line + "\n");
                } // Create a new file with name repeating for char length
                writer.close();
            }
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        } finally {
            // Do nothing
        }

        // Write Output File
        try
        {
            writer = new FileWriter(outputFilename);
            for(String name : firstNames){
                writer.write(name + "\n");
            }
            writer.close();
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        } finally {
            // Do nothing
        }
    }

    /**
     * Validates arguments (expects to find at least one string to be used as a file name)
     * @param args arguments
     * @return first argument
     * @throws MissingFileName if no arguments were provided
     */
    private static void validateArguments(String[] args) throws MissingFileName {
        if (args.length == NO_ARGUMENTS_LENGTH) {
            throw new MissingFileName("Missing required argument. (Must provide at least one string)");
        } else {
            // Do nothing
        }
    }

    /**
     * Validates file name (must be less or equal to 20 characters and end with the extension ".txt")
     * @param fileName filename
     * @return valid filename
     * @throws InvalidFileName if provided filename is invalid
     */
    private static String validateFileName(String fileName){
        if (fileName.length() > MIN_OUTPUT_FILE_CHAR_LENGTH || !fileName.endsWith(TEXT_FILE_EXTENSION)){
            throw new InvalidFileName("Invalid filename. " +
                                      "It must be less or equal to 20 characters and end with \".txt\"");
        } else {
            return fileName;
        }
    }
}