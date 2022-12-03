package ca.bcit.comp2601.assignment02.patterns;

/**
 * TextFile class
 *
 * @author Guilherme Trevisan, Monika Szucs
 * @version 0.0.1
 * @since 2022-12-03
 */
public class TextFile {
    private String name;

    /**
     * TextFileConstructor
     * @param name file name
     */
    public TextFile(final String name) {
        this.name = name;
    }

    /**
     * Open
     * Returns statement of what it would do when fully implemented
     * @return statement of what it would do when fully implemented
     */
    public String open() {
        return "Opening file \"" + name + "\"";
    }

    /**
     * Save
     * Returns statement of what it would do when fully implemented
     * @return statement of what it would do when fully implemented
     */
    public String save() {
        return "Saving file \"" + name + "\"";
    }

    /**
     * Edit
     * Returns statement of what it would do when fully implemented
     * @return statement of what it would do when fully implemented
     */
    public String edit() {
        return "Editing file \"" + name+ "\"";
    }

    /**
     * Write
     * Returns statement of what it would do when fully implemented
     * @return statement of what it would do when fully implemented
     */
    public String write() {
        return "Writing file \"" + name+ "\"";
    }

    /**
     * Copy
     * Returns statement of what it would do when fully implemented
     * @return statement of what it would do when fully implemented
     */
    public String copy() {
        return "Copying file \"" + name+ "\"";
    }

    /**
     * Copy
     * Returns statement of what it would do when fully implemented
     * @return statement of what it would do when fully implemented
     */
    public String paste() {
        return "Pasting file \"" + name+ "\"";
    }
}
