package ca.bcit.comp2601.lab04.guilhermetrevisan;

/**
 * FileManager Interface
 * @author Guilherme Trevisan
 * @version 0.0.1
 * @since   2022-09-16
 */
public interface FileManager {
    /**
     * Save the file using the provided file name
     * @param fileName fileName
     */

    void save(final String fileName);
    /**
     * Deletes the file using the provided file name
     * @param fileName fileName
     */
    void delete(final String fileName);
}
