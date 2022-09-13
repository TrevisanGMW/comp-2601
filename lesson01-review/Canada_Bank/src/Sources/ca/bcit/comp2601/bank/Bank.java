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
    private final Person ceo;
    private ArrayList<BankAccount> bankAccounts;

    /**
     * @param ceo
     * @param bankAccounts
     */
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

    /**
     * @param newAccount
     * @throws IllegalArgumentException if an account with the same number is already present in the account collection
     */
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


    /**
     * @param accountNumber
     * @thorw IllegalArgumentException if no account in the accounts' collection match the provided accountNumber
     */
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

    /**
     * Gets the account with the highest balance
     * @return BankAccount with the highest balance
     * @thorws IllegalArgumentException if bank has no accounts in it
     */
    public BankAccount getMaxAccount()
    {
        BankAccount maxAccount = null;
        double currentMaxValue = 0;
        for (BankAccount account : bankAccounts)
        {
            if (currentMaxValue < account.getBalanceUsd())
            {
                maxAccount = account;
                currentMaxValue = account.getBalanceUsd();
            }
        }

        if (maxAccount == null)
        {
            throw new IllegalArgumentException("Unable to find account. Bank has not accounts");
        }

        return maxAccount;
    }

    /**
     * @param clientID
     * @return account associated with provided ID
     * @thorws IllegalArgumentException if no accounts/client matches the provided clientID
     */
    public BankAccount getAccountFor(String clientID)
    {
        BankAccount foundAccount = null;
        for (BankAccount account : bankAccounts)
        {
            if (clientID.equalsIgnoreCase(account.getClient().getClientID()))
            {
                foundAccount = account;
            }
        }

        if (foundAccount == null)
        {
            throw new IllegalArgumentException("Unable to find account. No account matches the provided clientID");
        }

        return foundAccount;
    }


    /**
     * @return Person ceo
     */
    public Person getCeo() {
        return ceo;
    }

    /**
     * @return Array allBankAccounts
     */
    public BankAccount[] getAllAccounts()
    {
        BankAccount[] allBankAccounts;
        allBankAccounts = bankAccounts.toArray(new BankAccount[0]);
        return allBankAccounts;
    }
}
