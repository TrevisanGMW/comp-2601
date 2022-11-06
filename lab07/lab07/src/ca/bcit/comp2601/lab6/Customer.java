package ca.bcit.comp2601.lab6;

public class Customer {

    private String firstName;
    private String lastName;
    private String passcode;
    private Account account;

    /**
     * Default constructor for a Customer. Sets the fields to the default values for each type.
     */
    public Customer(){

    }

    /**
     * Overloaded customer constructor
     * @param firstName String to initialize the firstName field
     * @param lastName String to initialize the lastName field
     * @param passcode String to initialize the passcode field
     */
    public Customer(final String firstName, final String lastName, final String passcode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.passcode = passcode;
    }

    /**
     * Accessor for a Cutomer's collection of Accounts
     * @return a customer account as an Account
     */
    public Account getAccount(){
        return account;
    }

    /**
     * Mutator for the Account filed
     * @param account the Account to set
     */
    public void setAccount(Account account){
        this.account = account;
    }

    /**
     * Accessor method for the firstName field
     * @return the firstName as a String
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Mutator for the firstName field
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Accessor method for the lastName
     * @return the lastName as a String
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Mutator for the lastName field
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Accessor method for the passcode field
     * @return the passcode as a String
     */
    public String getPasscode() {
        return passcode;
    }

    /**
     * Mutator for the passcode field
     * @param passcode the passcode to set
     */
    public void setPasscode(String passcode) {
        this.passcode = passcode;
    }

    /**
     * Override toString
     * @return object as string
     */
    public String toString(){
        return this.toString();
    }
}
