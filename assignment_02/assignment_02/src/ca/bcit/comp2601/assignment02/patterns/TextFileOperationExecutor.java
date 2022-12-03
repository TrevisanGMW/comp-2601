package ca.bcit.comp2601.assignment02.patterns;

import java.util.ArrayList;
import java.util.List;

/**
 * TextFileOperationExecutor as the Invoker class
 *
 * @author Guilherme Trevisan, Monika Szucs
 * @version 0.0.1
 * @since 2022-12-03
 */
public class TextFileOperationExecutor {

    private final List<TextFileOperation> textFileOperations = new ArrayList<>();

    /**
     * Runs provided concrete operation
     * @param textFileOperation concrete command textFileOperation (execute)
     * @return
     */
    public String executeOperation(final TextFileOperation textFileOperation) {
        textFileOperations.add(textFileOperation);
        return textFileOperation.execute();
    }
}
