package ca.bcit.comp2601.assignment02.patterns;

/**
 * TextFileOperation as the command interface
 *
 * @author Guilherme Trevisan, Monika Szucs
 * @version 0.0.1
 * @since 2022-12-03
 */
@FunctionalInterface
public interface TextFileOperation {
    /**
     * Method to be implemented when executing operation
     * @return result of the operation
     */
    String execute();
}