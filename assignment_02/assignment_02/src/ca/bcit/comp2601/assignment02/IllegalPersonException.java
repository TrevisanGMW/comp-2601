package ca.bcit.comp2601.assignment02;

/**
 * IllegalPersonException class
 * This class extends the RuntimeException class. It satisfies its parent's constructor and does nothing else.
 *
 * @author Guilherme Trevisan
 * @version 0.0.1
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
