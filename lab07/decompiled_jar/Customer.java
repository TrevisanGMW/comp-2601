public class Customer {
    private String firstName;
    private String lastName;
    private String passcode;
    private Account account;

    public Customer() {
    }

    public Customer(String firstName, String lastName, String passcode) {
        setFirstName(firstName);
        setLastName(lastName);
        setPasscode(passcode);
    }

    public Account getAccount() {
        return this.account;
    }


    public void setAccount(Account account) {
        if (account != null) {
            this.account = account;
        }
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName != null && !firstName.trim().isEmpty()) {
            this.firstName = firstName;
        }
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        if (lastName != null && !lastName.trim().isEmpty()) {
            this.lastName = lastName;
        }
    }

    public String getPasscode() {
        return this.passcode;
    }

    public void setPasscode(String passcode) {
        if (passcode != null && !passcode.trim().isEmpty()) {
            this.passcode = passcode;
        }
    }

    public String toString() {
        return "Customer [firstName=" + this.firstName + ", lastName=" + this.lastName + ", passcode=" + this.passcode + ", account=" + this.account + "]";
    }
}
