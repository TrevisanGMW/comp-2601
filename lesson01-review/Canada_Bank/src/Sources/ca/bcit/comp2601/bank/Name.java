package ca.bcit.comp2601.bank;

/**
 * The HelloWorld program implements an application that
 *
 * @author  Guilherme Trevisan
 * @version 0.0.1
 * @since   2022-09-10
 */

public class Name
{
    private final String first;
    private final String last;
    private static final int NAME_MAX_LENGTH = 45;
    private static final String NAME_INVALID_STRING = "admin";

    /**
     * Create a public constructor that takes first, last as arguments:
     * they must not be null nor blank;
     * must be fewer than 45 characters;
     * must not contain the word "admin" (in any letter casing)
     * @param first first name string
     * @param last last name string
     * @throws IllegalArgumentException when provided argument
     *                                  doesn't follow accepted patterns
     */
    public Name(String first, String last)
    {
        this.first = validateName(first);
        this.last = validateName(last);
    }

    /**
     * Getter First
     * @return first name
     */
    public String getFirst()
    {
        return first;
    }

    /**
     * Getter Last
     * @return last name
     */
    public String getLast()
    {
        return last;
    }

    /**
     * Get Initials (always uppercase)
     * @return initials in the following format: First Last = "F.L."
     */
    public String getInitials()
    {
        return first.substring(0, 1).toUpperCase() + "." + last.substring(0, 1).toUpperCase() + ".";
    }

    /**
     * Gets Full Name (First and Last name) - Result is capitalized (e.g. fIrSt lAsT -> First Last)
     * @return fullName first and last name
     */
    public String getFullName()
    {
        return first.substring(0, 1).toUpperCase() + first.substring(1).toLowerCase()
                + " " + last.substring(0, 1).toUpperCase() + last.substring(1).toLowerCase();
    }

    /**
     * String must not be null nor blank;
     * String must be fewer than 45 characters;
     * String must not contain the word "admin" (in any letter casing)
     * @param inputString string to check (first or last)
     * @return validString
     * @throws IllegalArgumentException when provided argument
     *                                  doesn't follow accepted patterns
     */
    private static String validateName(String inputString)
    {
        if(inputString == null)
        {
            throw new IllegalArgumentException("Invalid name. It cannot be null.");
        }
        else if (inputString.replaceAll("\\s+","").equals(""))
        {
            throw new IllegalArgumentException("Invalid name. Cannot be empty.");
        }
        else if (inputString.toLowerCase().contains(NAME_INVALID_STRING))
        {
            throw new IllegalArgumentException("Invalid name. Cannot contain \"" + NAME_INVALID_STRING + "\".");
        }
        else if (inputString.length() >= NAME_MAX_LENGTH)
        {
            throw new IllegalArgumentException("Invalid name. Cannot be more than " + NAME_MAX_LENGTH + " characters.");
        }
        else
        {
            return inputString;
        }
    }


}
