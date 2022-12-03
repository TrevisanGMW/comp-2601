package ca.bcit.comp2601.assignment02.junit;

/**
 * IllegalPersonException class - Copied from Assignment 01 (Used for Unit Testing)
 * This class extends the RuntimeException class. It satisfies its parent's constructor and does nothing else.
 *
 * @author Guilherme Trevisan, Monika Szucs
 * @version 0.0.2
 * @since 2022-10-10
 */

public class IllegalPersonException extends RuntimeException {
    /**
     * Passes message to RuntimeException
     * @param message error message
     */
    public IllegalPersonException(String message) {
        super(message);
    }
}
