package ca.bcit.comp2601.assignment01;

/**
 * Person class
 * @author Guilherme Trevisan
 * @version 0.0.1
 * @since 2022-10-10
 */

public class Person implements Comparable {
    private final Name name;
    private final Date born;
    private Date died;

    private static final int COMPARABLE_LARGER;
    private static final int COMPARABLE_EQUAL;
    private static final int COMPARABLE_SMALLER;

    static {
        COMPARABLE_LARGER = 1;
        COMPARABLE_EQUAL = 0;
        COMPARABLE_SMALLER = -1;
    }

    /**
     * Default constructor to create a person
     * @param name Name object
     * @param born Date object for the birthdate
     * @throws IllegalPersonException if any arguments are invalid
     */
    public Person(Date born, Name name) {
        if (name != null) {
            this.name = name;
        }
        else {
            throw new IllegalPersonException("Invalid argument. Name cannot be null.");
        }

        if (born != null) {
            this.born = born;
        }
        else {
            throw new IllegalPersonException("Invalid argument. birthDate cannot be null.");
        }
    }

    /**
     * Dead person constructor
     * @param born when the person was born
     * @param name person's name
     * @param died Date when the person died (can be null in case it hasn't happened)
     * @throws IllegalPersonException if any arguments are invalid
     */
    public Person(Date born, Name name, Date died) {
        this(born, name);
        this.died = died;
    }

    /**
     * Potentially Dead person constructor
     * @param born when the person was born
     * @param name person's name
     * @param died Date when the person died (can be null in case it hasn't happened)
     * @throws IllegalPersonException if any arguments are invalid
     */
    public Person(Date born, Name name, Object died) {
        this(born, name);
        if (died != null && died instanceof Date){
            this.died = (Date) died;
        }
    }

    /**
     *  Returns customized sentence with details about the person
     *  "Tiger Woods (alive) was born on tuesday, December 30, 1975!"
     *  "Albert Einstein (died monday, April 18, 1955) was born on friday, March 14, 1879!”
     * @return String following the format mentioned above
     */
    public String getDetails() {
        String result;
        String livingCondition;

        if (isAlive()) {
            livingCondition = "(alive)";
        }
        else {
            livingCondition = "(died " + died.getDayOfTheWeek().toLowerCase() +
                    ", " + died.getDateAsText() +  ")";
        }

        result = name.getPrettyName() + " " + livingCondition + " was born on " +
                born.getDayOfTheWeek().toLowerCase() + ", " + born.getDateAsText() + "!";
        return result;
    }

    /**
     * Add a dateOfDeath (Kills the person)
     * @param dateOfDeath date when the person died
     * @throws IllegalArgumentException
     */
    public void die(Date dateOfDeath){
        if (name != null) {
            this.died = dateOfDeath;
        }
        else {
            throw new IllegalPersonException("Invalid date of death. It cannot be null.");
        }
    }

    /**
     * Returns true if the person hasn't died (is still alive)
     * @return true if the person is alive (in case deathDate is not null)
     */
    public boolean isAlive() {
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
    public Date getDateOfBirth() {
        return born;
    }

    /**
     * Getter deathDate
     * @return deathDate
     */
    public Date getDateOfDeath() {
        return died;
    }

    /**
     * returns a String in one of these two exact formats:
     * Alive people example: "Tiger Woods was born 1975-12-30 and is still alive"
     * Dead people example: "Albert Einstein was born 1879-03-14 and died 1955-04-18"
     * @return formatted string
     */
    @Override
    public String toString() {
        return getDetails();
    }

    /**
     * compareTo for person specifically (not an override)
     * @param that a person to compare with this
     * @return positive
     */
    public int compareTo(Person that) {
        if (this.getDateOfBirth() == null && that.getDateOfBirth() == null) {
            // pass
        } else if (this.getDateOfBirth() == null) {
            return COMPARABLE_SMALLER;
        } else if (that.getDateOfBirth() == null) {
            return COMPARABLE_LARGER;
        } else {
            int bornComparison = this.getDateOfBirth().compareTo(that.getDateOfBirth());
            if (bornComparison != 0) {
                return bornComparison < COMPARABLE_EQUAL ? COMPARABLE_SMALLER : COMPARABLE_LARGER;
            } else {
                // Do nothing
            }
        }
        return COMPARABLE_EQUAL;
    }

    //public int compareTo(Person p): this method satisfies the requirements from implementing the Comparable interface.
    // Younger people are "larger". Note: this method must use its born variable's compareTo(Date d) method.
    /**
     * Override compareTo
     * @param o the object to be compared.
     * @return larger if younger
     */
    @Override
    public int compareTo(Object o) {
        if (o == null){
            return COMPARABLE_SMALLER;
        }
        else if (this == o){
            return COMPARABLE_EQUAL;
        }
        else if (o instanceof Person){
            Person p1;
            p1 = (Person)o;
            return this.compareTo(p1);
        } else {
            return COMPARABLE_EQUAL;
        }
    }

}
