package ca.bcit.comp2601.bank;

import java.util.ArrayList;

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
    private ArrayList<BankAccount> bankAccounts;

    public Bank(Person ceo, ArrayList<BankAccount> bankAccounts) {
        this.ceo = ceo;

        if (bankAccounts == null)
        {
            this.bankAccounts = new ArrayList<BankAccount>();
        }
        else
        {
            this.bankAccounts = bankAccounts;
        }
    }

    public void addAccount(BankAccount newAccount)
    {
        for (BankAccount account : bankAccounts)
        {
            if (newAccount.getAccountNumber() == account.getAccountNumber())
            {
                throw new IllegalArgumentException("Invalid account. Account number is already present in the bank");
            }
        }
        bankAccounts.add(newAccount);
    }


    public void removeAccount(String accountNumber)
    {
        boolean accountFound;
        accountFound = false;
        for (BankAccount account : bankAccounts)
        {
            if (accountNumber == account.getAccountNumber())
            {
                bankAccounts.remove(account);
                accountFound = true;
            }
        }

        if (accountFound != true)
        {
            throw new IllegalArgumentException("Invalid account. Unable to find account number in the collection");
        }

    }


    public Person getCeo() {
        return ceo;
    }

    public BankAccount[] getAllAccounts()
    {
        BankAccount[] allBankAccounts;
        allBankAccounts = bankAccounts.toArray(new BankAccount[0]);
        return allBankAccounts;
    }
}
