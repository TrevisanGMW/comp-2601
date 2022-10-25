package ca.bcit.comp2601.assignment01;

/**
 * Person class
 * This class implements the Comparable interface (details below).
 * This class has instance variables and accessor methods for Date born, Date died, and Name name.
 * It has the following methods:
 * public Person (Date born, Name name): This constructor throws IllegalPersonException exceptions
 *                                       if either born or name is null.
 * public void die(Date dateOfDeath): this method sets the died instance variable to the dateOfDeath provided.
 * public boolean isAlive(): this method returns true if the Person is alive; otherwise returns false.
 * public int compareTo(Person p): this method satisfies the requirements from implementing the Comparable interface.
 * Younger people are "larger". Note: this method must use its born variable's compareTo(Date d) method.
 * This class overrides the public String toString() method, which returns a String in one of these two exact formats:
 * a) Alive people example: "Tiger Woods was born 1975-12-30 and is still alive"
 * b) Dead people example: "Albert Einstein was born 1879-03-14 and died 1955-04-18"
 * Use the name variable's getPrettyName() method, and the born/died getYyyyMmDd() method.
 *
 * @author Guilherme Trevisan
 * @version 0.0.1
 * @since 2022-10-10
 */

public class Person implements Comparable {
    private final Name name;
    private final Date born;
    private final Date died;

    /**
     * @param name Name object
     * @param born Date object for the birth date
     * @param died (can be null)
     * @throws IllegalArgumentException if any arguments are invalid
     */
    public Person(Name name, Date born, Date died)
    {
        if (name != null)
        {
            this.name = name;
        }
        else
        {
            throw new IllegalArgumentException("Invalid argument. Name cannot be null.");
        }

        if (born != null)
        {
            this.born = born;
        }
        else
        {
            throw new IllegalArgumentException("Invalid argument. birthDate cannot be null.");
        }
        this.died = died;
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
            livingCondition = "(died " + died.getDayOfTheWeek().toLowerCase() +
                    ", " + died.getDateAsText() +  ")";
        }

        result = name.getPrettyName() + " " + livingCondition + " was born on " +
                born.getDayOfTheWeek().toLowerCase() + ", " + born.getDateAsText() + "!";
        return result;
    }

    /**
     * @return true if the person is alive (in case deathDate is not null)
     */
    public boolean isAlive()
    {
        return (this.died == null);
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
    public Date getBorn() {
        return born;
    }

    /**
     * Getter deathDate
     * @return deathDate
     */
    public Date getDied() {
        return died;
    }

    /**
     * Compares this object with the specified object for order.  Returns a
     * negative integer, zero, or a positive integer as this object is less
     * than, equal to, or greater than the specified object.
     *
     * <p>The implementor must ensure {@link Integer#signum
     * signum}{@code (x.compareTo(y)) == -signum(y.compareTo(x))} for
     * all {@code x} and {@code y}.  (This implies that {@code
     * x.compareTo(y)} must throw an exception if and only if {@code
     * y.compareTo(x)} throws an exception.)
     *
     * <p>The implementor must also ensure that the relation is transitive:
     * {@code (x.compareTo(y) > 0 && y.compareTo(z) > 0)} implies
     * {@code x.compareTo(z) > 0}.
     *
     * <p>Finally, the implementor must ensure that {@code
     * x.compareTo(y)==0} implies that {@code signum(x.compareTo(z))
     * == signum(y.compareTo(z))}, for all {@code z}.
     *
     * @param o the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object
     * is less than, equal to, or greater than the specified object.
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException   if the specified object's type prevents it
     *                              from being compared to this object.
     * @apiNote It is strongly recommended, but <i>not</i> strictly required that
     * {@code (x.compareTo(y)==0) == (x.equals(y))}.  Generally speaking, any
     * class that implements the {@code Comparable} interface and violates
     * this condition should clearly indicate this fact.  The recommended
     * language is "Note: this class has a natural ordering that is
     * inconsistent with equals."
     */
    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
