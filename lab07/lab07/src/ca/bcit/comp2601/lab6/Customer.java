package ca.bcit.comp2601.lab6;

public class Customer {

    private String firstName;
    private String lastName;
    private String passcode;
    private Account account;

    public Customer(final String firstName, final String lastName, final String passcode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.passcode = passcode;
    }

    public Account getAccount(){
        return account;
    }

    public void setAccount(Account account){
        this.account = account;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPasscode() {
        return passcode;
    }

    public void setPasscode(String passcode) {
        this.passcode = passcode;
    }

    public String toString(){
        return this.toString();
    }
}
