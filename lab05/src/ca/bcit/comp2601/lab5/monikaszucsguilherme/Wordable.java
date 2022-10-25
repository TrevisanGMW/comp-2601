package ca.bcit.comp2601.lab5.monikaszucsguilherme;

/**
 * Wordable.java
 *
 * COMP 2601 - CRN: 48065
 * Friday evenings, Fall 2022
 * Lab #5
 *
 * @author Monika Szucs
 * @author Guilherme Trevisan
 * @version 1.1
 *
 */
@FunctionalInterface
interface Wordable {

    /**
     * @param s a word to be used in the method
     * @param n a number
     * @return a processed string
     */
    String createString(String s, int n);
}
