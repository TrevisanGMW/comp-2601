package ca.bcit.comp2601.quiz;

/**
 * Class Describing SoccerPlayer
 *
 * @author Guilherme Trevisan
 * @version 0.0.1
 * @since 2022-10-14
 */
public class SoccerPlayer implements Printable, Comparable<SoccerPlayer>{
    private final String firstName;
    private final String lastName;
    private final int jerseyNumber;

    private static final int LARGER = 1;
    private static final int SMALLER = -1;
    private static final int EQUAL = 0;

    /**
     * Constructor for Soccer Player
     * @param firstName firstName
     * @param lastName lastName
     * @param jerseyNumber jeyseyNumber
     */
    public SoccerPlayer(String firstName, String lastName, int jerseyNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.jerseyNumber = jerseyNumber;
    }

    /**
     * Getter firstName
     * @return firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Getter lastName
     * @return lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Getter jerseyNumber
     * @return jerseyNumber
     */
    public int getJerseyNumber() {
        return jerseyNumber;
    }

    /**
     * Prints soccer player details in this format: "<lastName> is number <jeyseyNumber>"
     */
    @Override
    public void printDetails() {
        System.out.println(lastName + " is number " + jerseyNumber);
    }

    /**
     * Override compareTo
     * @param that the object to be compared.
     * @return bigger depending on the jeyseyNumber
     */
    @Override
    public int compareTo(SoccerPlayer that) {
        if (this.jerseyNumber != that.jerseyNumber) {
            return (this.jerseyNumber < that.jerseyNumber ? SMALLER : LARGER);
        }
        return EQUAL;
    }
}
