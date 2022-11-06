import java.util.HashMap;


public class Bank {
    public static HashMap<String, Customer> theBank;

    public Bank() {
        theBank = new HashMap<>();
    }

    public static void displayCustomerInformation(Customer customer) {
        if (customer != null) {
            System.out.println(customer);
        }
    }

    public static void displayAllCustomers() {
        for (Customer customer : theBank.values()) {
            System.out.println(customer);
        }
    }

    public void addCustomer(Customer newCustomer) {
        if (newCustomer != null) {
            theBank.put(newCustomer.getAccount().getAccountNumber(), newCustomer);
        }
    }

    public void closeAccount(String accountNumber) {
        if (accountNumber != null) {
            theBank.remove(accountNumber);
        }
    }
}
