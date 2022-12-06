package ca.bcit.comp2601.assignment02;

import java.io.FileNotFoundException;

/**
 * Main Class
 *
 * @author Guilherme Trevisan, Monika Szucs
 * @version 0.0.1
 * @since 2022-11-28
 */
public class Main {
    /**
     * Main - Program entry point
     * @param args commandline parameters
     */
    public static void main(final String[] args) throws FileNotFoundException, InterruptedException {
        Menu m = new Menu();
        m.runMenu();
    }
}
