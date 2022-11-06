package ca.bcit.comp2601.lab6;

/**
 * Account Class
 * @author (Originally Bullwinkle Moose) - Recreated by Guilherme and Monika
 * @version 2019.04.20
 */
public class Account {

    private final String accountNumber;
    private double balance;
    private boolean active;
    private static final boolean DEFAULT_ACTIVATION;

    static {
        DEFAULT_ACTIVATION = false;
    }

    /**
     * Default constructor to create Account objects
     */
    Account(){
        this.accountNumber = null;
        this.active = DEFAULT_ACTIVATION;
    }

    /**
     * Overloaded Account constructor
     * @param accountNumber to set the accountNumber field
     * @param balance  to set the balance field
     */
    Account(final String accountNumber, final double balance){
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    /**
     * Getter accountNumber
     * @return the accountNumber as a String
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * accessor for the accountNumber field
     * @return the accountNumber as a String
     */
    public double getBalance() {
        return balance;
    }

    /**
     * mutator fir the balance field
     * @param balance the balance to set
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * accessor for the active field
     * @return the active boolean
     */
    public boolean isActive(){
        return active;
    }

    /**
     * mutator for the active field
     * @param active the active to set
     */
    public void setActive(boolean active){
        this.active = active;
    }

    /**
     * Adds to an Account balance
     * @param amount a double to add to the existing balance field
     */
    public void addToBalance(double amount){
        balance += amount;
    }

    /**
     * Subtracts from an Account balance
     * @param amount a double to subtract from the balance field
     */
    public void subtractFromBalance(double amount){
        balance -= amount;
    }

    /**
     * Overrides toString
     * @return object as String
     */
    @Override
    public String toString() {
        return this.toString();
    }
}
