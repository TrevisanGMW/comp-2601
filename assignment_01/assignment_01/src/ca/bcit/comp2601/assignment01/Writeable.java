package ca.bcit.comp2601.assignment01;

/**
 * Writeable Interface
 * This functional interface has one abstract method:
 * public void printDate(String s, int min, int max)
 *
 *
 * @author Guilherme Trevisan
 * @version 0.0.1
 * @since 2022-10-10
 */
@FunctionalInterface
public interface Writeable {
    /**
     * pridateDate function
     * @param s string to print
     * @param min minimum value
     * @param max maximum value
     */
    public void printDate(String s, int min, int max);
}
