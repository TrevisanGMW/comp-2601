package ca.bcit.comp2601.lab6;

public class Account {

    private String accountNumber;
    private double balance;
    private boolean active;

    Account(final String accountNumber, final double balance){
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean isActive(){
        return active;
    }

    public void setActive(boolean active){

    }

    public void addToBalance(double amount){
        balance += amount;
    }

    public void subtractFromBalance(double amount){
        balance -= amount;
    }

    @Override
    public String toString() {
        return this.toString();
    }
}
