package ca.bcit.comp2601.assignment02.patterns;

/**
 * OpenTextFileOperation concrete command
 *
 * @author Guilherme Trevisan, Monika Szucs
 * @version 0.0.1
 * @since 2022-12-03
 */
public class OpenTextFileOperation implements TextFileOperation {

    private final TextFile textFile;

    /**
     * OpenTextFileOperation constructor
     * @param textFile file to be affected by the command
     */
    public OpenTextFileOperation(final TextFile textFile) {
        this.textFile = textFile;
    }

    /**
     * Command implementation (what will happen when executing concrete action)
     * @return output of the open operation
     */
    @Override
    public String execute() {
        return textFile.open() + " (From Concrete Command)";
    }
}
