package ca.bcit.comp2601.bank;

/**
 * Bank
 * has a CEO who is a Person;
 * has an ArrayList of BankAccount references;
 * addAccount() throws an IllegalArgumentException if an account is being added but its accountNumber is
 * already in the Bank's account collection;
 * getCeo() returns the current CEO
 *
 *
 * Instance variables, constructor arguments, accessor methods for:
 * ArrayList of BankAccounts
 *
 * Methods:
 * addAccount(newAccount)
 * removeAccount(accountNumber)
 * getAllAccounts() // an Array
 * getMaxAccount() // most $
 * getAccountFor(client ID)
 *
 */

public class Bank
{
    private Person ceo;
    private BankAccount[] bankAccounts;
}
