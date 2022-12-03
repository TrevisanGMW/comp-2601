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

//        CountryList cl = new CountryList();
//        CountryProcessor cp = new CountryProcessor();
//        cp.processCountries();

        Tester tester = new Tester();
        tester.test();
    }
}