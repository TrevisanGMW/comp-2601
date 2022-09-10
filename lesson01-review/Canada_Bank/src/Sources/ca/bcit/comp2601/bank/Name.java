package ca.bcit.comp2601.bank;

public class Name
{
    private final String first;
    private final String last;

    /**
     * Create a public constructor that takes first, last as arguments:
     * they must not be null nor blank;
     * must be fewer than 45 characters;
     * must not contain the word "admin" (in any letter casing)
     * @param first
     * @param last
     */
    Name(String first, String last)
    {
        if(first != null && first != "" && first.toLowerCase() != "admin" && first.length() < 46)
        {
            this.first = first;
        }
        else
        {
            throw new IllegalArgumentException("Invalid first name");
        }

        if(last != null && last != ""&& first.toLowerCase() != "admin" && first.length() < 46)
        {
            this.last = last;
        }
        else
        {
            throw new IllegalArgumentException("Invalid last name");
        }

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
        return first + " " + last;
    }



}
