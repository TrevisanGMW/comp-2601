package ca.bcit.comp2601.quiz_03;

/**
 * IllegalDivisorException class
 * This class extends the Exception class.
 *
 * @author Guilherme Trevisan
 * @version 0.0.1
 * @since 2022-11-12
 */

public class IllegalDivisorException extends Exception {
    /**
     * Passes message to RuntimeException
     * @param message error message
     */
    public IllegalDivisorException(String message) {
        super(message);
    }
}
