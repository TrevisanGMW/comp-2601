public class Account {
    private String accountNumber;
    private double balance;
    private boolean active;

    public Account() {
    }

    public Account(String accountNumber, double balance) {
        if (accountNumber != null) {
            this.accountNumber = accountNumber;
        }
        setBalance(balance);
        this.active = true;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public double getBalance() {
        return this.balance;
    }

    public void setBalance(double balance) {
        if (balance >= 0.0D) {
            this.balance = balance;
        }
    }

    public boolean isActive() {
        return this.active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void addToBalance(double amount) {
        if (amount > 0.0D) {
            this.balance += amount;
        }
    }

    public void subtractFromBalance(double amount) {
        if (amount > 0.0D) {
            this.balance -= amount;
        }
    }

    public String toString() {
        return "Account [accountNumber=" + this.accountNumber + ", balance=" + this.balance + ", active=" + this.active + "]";
    }
}
