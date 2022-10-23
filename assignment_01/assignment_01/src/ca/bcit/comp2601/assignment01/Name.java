package ca.bcit.comp2601.assignment01;

/**
 * Name Class
 * @author Guilherme Trevisan
 * @version 0.0.1
 * @since 2022-10-10
 */

public class Name {
    private final String first;
    private final String last;
    private static final int FIRST_CHAR_INDEX = 0;
    private static final int SECOND_CHAR_INDEX = 1;

    /**
     * Constructor Name object
     * @param first first name
     * @param last last name
     * @throws IllegalArgumentException when provided argument is null
     */
    public Name(final String first, final String last){
        if(first == null || first.isBlank()) {
            throw new IllegalArgumentException("Invalid name. It cannot be null.");
        } else {
            this.first = first;
        }

        if(last == null || last.isBlank()) {
            throw new IllegalArgumentException("Invalid name. It cannot be null.");
        } else {
            this.last = last;
        }
    }

    /**
     * Gets Pretty Name (First and Last name) - Result is capitalized (e.g. fIrSt lAsT -> First Last)
     * @return fullName first and last name
     */
    public String getPrettyName()
    {
        return first.substring(FIRST_CHAR_INDEX, SECOND_CHAR_INDEX).toUpperCase() +
                first.substring(SECOND_CHAR_INDEX).toLowerCase() + " " +
                last.substring(FIRST_CHAR_INDEX, SECOND_CHAR_INDEX).toUpperCase() +
                last.substring(SECOND_CHAR_INDEX).toLowerCase();
    }

    /**
     * Get Initials (always uppercase)
     * @return initials in the following format: First Last = "F.L."
     */
    public String getInitials()
    {
        return first.substring(FIRST_CHAR_INDEX, SECOND_CHAR_INDEX).toUpperCase() + "." +
                last.substring(FIRST_CHAR_INDEX, SECOND_CHAR_INDEX).toUpperCase() + ".";
    }

    // Getters
    /**
     * Getter First Name
     * @return first
     */
    public String getFirst() {
        return first;
    }

    /**
     * Getter Last Name
     * @return last
     */
    public String getLast() {
        return last;
    }
}
