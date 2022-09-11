package ca.bcit.comp2601.bank;

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
     */
    public Name(String first, String last)
    {
        this.first = validateName(first);
        this.last = validateName(last);
    }

    public String getFirst()
    {
        return first;
    }

    public String getLast()
    {
        return last;
    }

    public String getInitials()
    {
        return first.substring(0, 1).toUpperCase() + last.substring(0, 1).toUpperCase();
    }

    public String getFullName()
    {
        return first.substring(0, 1).toUpperCase() + first.substring(1).toLowerCase()
                + " " + last.substring(0, 1).toUpperCase() + last.substring(1).toLowerCase();
    }

    /**
     * @param inputString string to check (first or last)
     * @return validString
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
            throw new IllegalArgumentException("Invalid name. Cannot have more than 45.");
        }
        else
        {
            return inputString;
        }
    }


}
