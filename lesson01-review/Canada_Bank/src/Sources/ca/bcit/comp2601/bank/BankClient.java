package ca.bcit.comp2601.bank;

/**
 * BankClient (extends Person; has a dateJoinedBank Date; has a String clientID which is 5 digits;
 * overrides getDetails() to return a String in the exact format of
 * "Tiger Woods client #12345 (alive) joined the bank on thursday, September 3, 2020")
 * [note: or “not alive” as the case may be].
 *
 * Instance variables, constructor arguments, accessor methods for:
 *  client ID: 5 digits
 *  dateJoinedTheBank
 *
 * Methods:
 * getDetails()
 *
 */

public class BankClient extends Person
{
    private final Date dateJoinedBank;
    private final String clientID; // 5 digits
    private static final int LENGTH_CLIENT_ID = 5;

    /**
     * @param name Name object
     * @param birthDate Date birthDate
     * @param deathDate Date deathDate (can be null)
     * @param dateJoinedBank Date dateJoinedBank
     * @param clientID String must be 5 digits
     */
    public BankClient(Name name, Date birthDate, Date deathDate, Date dateJoinedBank, String clientID) {
        super(name, birthDate, deathDate);

        if (dateJoinedBank == null)
        {
            throw new IllegalArgumentException("Invalid dateJoinedBank. Cannot be null");
        }
        else
        {
            this.dateJoinedBank = dateJoinedBank;
        }

        if (clientID == null)
        {
            throw new IllegalArgumentException("Invalid clientID. Cannot be null");
        }
        else if (!clientID.matches("\\d+") || clientID.length() != LENGTH_CLIENT_ID)
        {
            throw new IllegalArgumentException("Invalid clientID. Must be 5 digits");
        }
        else
        {
            this.clientID = clientID;
        }
    }

    /**
     * Getter dateJoinedBank
     * @return dateJoinedBank
     */
    public Date getDateJoinedBank() {
        return dateJoinedBank;
    }

    /**
     * Getter clientID
     * @return clientID
     */
    public String getClientID() {
        return clientID;
    }

    /**
     * "Tiger Woods client #12345 (alive) joined the bank on thursday, September 3, 2020")
     * [note: or “not alive” as the case may be].
     * @return String custom sentence showing details and client ID (follows pattern of the sentence above)
     */
    @Override
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
            livingCondition = "(died " + this.getDeathDate().getDayOfTheWeek().toLowerCase() +
                    ", " + this.getDeathDate().getDateAsText() +  ")";
        }

        result = this.getName().getFullName() + " " + livingCondition + " joined the bank on " +
                dateJoinedBank.getDayOfTheWeek().toLowerCase() + ", " + dateJoinedBank.getDateAsText() + "!";
        return result;
    }
}
