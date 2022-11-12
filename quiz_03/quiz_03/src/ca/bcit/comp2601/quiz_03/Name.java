package ca.bcit.comp2601.quiz_03;

/**
 * Name class
 * @author Guilherme Trevisan
 * @version 0.0.1
 * @since 2022-11-12
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
            throw new IllegalArgumentException("invalid first name");
        } else {
            this.first = first;
        }

        if(last == null || last.isBlank()) {
            throw new IllegalArgumentException("invalid last name");
        } else {
            this.last = last;
        }
    }

    /**
     * Getter first name (Title Case)
     * @return first name (Title Case)
     */
    public String getFirst() {
        return first.substring(FIRST_CHAR_INDEX, SECOND_CHAR_INDEX).toUpperCase() +
                first.substring(SECOND_CHAR_INDEX).toLowerCase();

    }

    /**
     * Getter last name (Title Case)
     * @return last name (Title Case)
     */
    public String getLast() {
        return last.substring(FIRST_CHAR_INDEX, SECOND_CHAR_INDEX).toUpperCase() +
                last.substring(SECOND_CHAR_INDEX).toLowerCase();
    }

    /**
     * The getName() method returns the first and last names in Title Case
     * @return title case name (first + last)
     */
    public String getName(){
        return getFirst() + " " + getLast();
    }
}
