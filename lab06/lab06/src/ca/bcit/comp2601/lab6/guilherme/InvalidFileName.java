package ca.bcit.comp2601.lab6.guilherme;

/**
 * InvalidFileName Exception
 * @author Guilherme Trevisan
 * @version 0.0.1
 * @since 2022-10-29
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
