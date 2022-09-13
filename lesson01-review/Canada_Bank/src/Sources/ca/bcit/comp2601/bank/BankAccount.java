package ca.bcit.comp2601.bank;

/**
 * BankAccount
 *
 * has overloaded methods for withdraw:
 * withdraw(final double amountUsd);
 * withdraw(final double amountUsd, final int pinToMatch);
 *
 * has a client;
 * has an account number which is 7 letters;
 * has a Date for accountOpened;
 * has a Date for accountClosed which can be null if it is not closed
 *
 * Instance variables, constructor arguments, accessor methods for:
 * client
 * balanceUsd
 * pin
 * account number: 7 letters
 *
 * Methods
 * deposit()
 * withdraw(amountUsd)
 * withdraw(amountUsd, pinToMatch)
 *
 */
public class BankAccount
{
    private final BankClient client;
    private final String accountNumber;
    private double balanceUsd;
    private final Date accountOpened;
    private final Date accountClosed;
    private int pin;
    private static final int LENGTH_ACCOUNT_NUM = 7;

    /**
     * @param client
     * @param balanceUsd
     * @param pin
     * @param accountNumber (must be 7 letters, length)
     * @param accountOpened
     * @param accountClosed can be null (not closed yet)
     */
    public BankAccount(BankClient client,
                       double balanceUsd,
                       int pin,
                       String accountNumber,
                       Date accountOpened,
                       Date accountClosed)
    {
        if (client == null)
        {
            throw new IllegalArgumentException("Invalid client. Cannot be null");
        }
        else
        {
            this.client = client;
        }

        this.balanceUsd = balanceUsd;
        this.pin = pin;
        

        if (accountNumber == null)
        {
            throw new IllegalArgumentException("Invalid clientID. Cannot be null");
        }
        else if (accountNumber.length() != LENGTH_ACCOUNT_NUM)
        {
            throw new IllegalArgumentException("Invalid clientID. Must be 5 digits");
        }
        else
        {
            this.accountNumber = accountNumber;
        }

        if (accountOpened == null)
        {
            throw new IllegalArgumentException("Invalid accountOpened. Cannot be null");
        }
        else
        {
            this.accountOpened = accountOpened;
        }
        this.accountClosed = accountClosed;

    }

    /**
     * @param amountUsd
     * @return boolean true if successful, false if not enough balance
     */
    public boolean withdraw(final double amountUsd)
    {
        if (amountUsd > balanceUsd)
        {
            return false;
        }
        else
        {
            balanceUsd = balanceUsd-amountUsd;
            return true;
        }
    }

    /**
     * @param amountUsd
     * @param pinToMatch
     * @return boolean true if successful, false if not enough balance or wrong pin
     */
    public boolean withdraw(final double amountUsd, final int pinToMatch) {
        if (amountUsd > balanceUsd) {
            return false;
        } else {
            if (pinToMatch == pin) {
                balanceUsd = balanceUsd - amountUsd;
                return true;
            } else {
                return false;
            }

        }

    }

    /**
     * Can only deposit positive values
     * @param amountUsd
     * @return boolean, true if success, false if failed.
     */
    public boolean deposit(final double amountUsd)
    {
        if (amountUsd > 0){
            balanceUsd = balanceUsd+amountUsd;
            return true;
        }
        else
        {
            return false;
        }
    }


    /**
     * @return boolean true if closed, false if still opened (no closing date)
     */
    public boolean isClosed()
    {
        if (accountClosed == null)
        {
            return false;
        }
        else
        {
            return true;
        }
    }


    /**
     * @return client
     */
    public BankClient getClient() {
        return client;
    }

    /**
     * @return accountNumber
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * @return balanceUsd
     */
    public double getBalanceUsd() {
        return balanceUsd;
    }

    /**
     * @return accountOpened
     */
    public Date getAccountOpened() {
        return accountOpened;
    }

    /**
     * @return accountClosed
     */
    public Date getAccountClosed() {
        return accountClosed;
    }

    /**
     * @return pin
     */
    public int getPin() {
        return pin;
    }
}
