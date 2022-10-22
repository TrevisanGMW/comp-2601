package ca.bcit.comp2601.lab05;

/**
 * 1. Create a functional interface called Wordable with the abstract function the following signature:
 * String createString(String s, int n)
 *
 *  Wordable Interface
 *  @author Guilherme Trevisan & Monica Szucs
 *  @version 0.0.1
 *  @since 2022-10-21
 */
@FunctionalInterface
public interface Wordable {
    /**
     * Single abstract function to be implemented as lambda expressions
     * @param s generic string argument
     * @param n generic number argument
     * @return processed string result
     */
    String createString(String s, int n);
}
