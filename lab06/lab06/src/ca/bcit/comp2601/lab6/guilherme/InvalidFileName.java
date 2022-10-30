package ca.bcit.comp2601.lab6.guilherme;

/**
 * InvalidFileName Exception
 */
public class InvalidFileName extends RuntimeException{
    /**
     * InvalidFileName Constructor
     * @param message message to display as an exception
     */
    public InvalidFileName(String message) {
        super(message);
    }
}
