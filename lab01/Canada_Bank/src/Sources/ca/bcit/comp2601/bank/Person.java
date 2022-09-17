package ca.bcit.comp2601.bank;


/**
 * Person (has a Name and a birthDate and a deathDate [which can be null];
 * has a getDetails() method which returns a String in the exact format of
 * "Tiger Woods (alive) was born on tuesday, December 30, 1975!" or
 * “Albert Einstein (died monday, April 18, 1955) was born on friday, March 14, 1879!”.
 *
 * Instance variables, constructor arguments, accessor methods for:
 * name
 * date born
 * date died
 *
 * Methods:
 * getDetails()
 * isAlive()
 *
 *  @author  Guilherme Trevisan
 *  @version 0.0.1
 *  @since   2022-09-10
 *
 */
public class Person
{
    private final Name name;
    private final Date birthDate;
    private final Date deathDate;

    /**
     * @param name Name object
     * @param birthDate Date object for the birth date
     * @param deathDate (can be null)
     * @throws IllegalArgumentException if any arguments are invalid
     */
    public Person(Name name, Date birthDate, Date deathDate)
    {
        if (name != null)
        {
            this.name = name;
        }
        else
        {
            throw new IllegalArgumentException("Invalid argument. Name cannot be null.");
        }

        if (birthDate != null)
        {
            this.birthDate = birthDate;
        }
        else
        {
            throw new IllegalArgumentException("Invalid argument. birthDate cannot be null.");
        }
        this.deathDate = deathDate;
    }

    /**
     *  Returns customized sentence with details about the person
     *  "Tiger Woods (alive) was born on tuesday, December 30, 1975!"
     *  "Albert Einstein (died monday, April 18, 1955) was born on friday, March 14, 1879!”
     * @return String following the format mentioned above
     */
    public String getDetails()
    {
        String result;
        String livingCondition;

        if (isAlive())
        {
            livingCondition = "(alive)";
        }
        else
        {
            livingCondition = "(died " + deathDate.getDayOfTheWeek().toLowerCase() +
                              ", " + deathDate.getDateAsText() +  ")";
        }

        result = name.getFullName() + " " + livingCondition + " was born on " +
                 birthDate.getDayOfTheWeek().toLowerCase() + ", " + birthDate.getDateAsText() + "!";
        return result;
    }

    /**
     * @return true if the person is alive (in case deathDate is not null)
     */
    public boolean isAlive()
    {
        return (this.deathDate == null);
    }

    /**
     * Getter name
     * @return name
     */
    public Name getName() {
        return name;
    }

    /**
     * Getter birthDate
     * @return birthDate
     */
    public Date getBirthDate() {
        return birthDate;
    }

    /**
     * Getter deathDate
     * @return deathDate
     */
    public Date getDeathDate() {
        return deathDate;
    }
}
