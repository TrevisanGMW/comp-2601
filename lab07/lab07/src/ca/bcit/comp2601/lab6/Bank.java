package ca.bcit.comp2601.lab6;

import java.util.HashMap;
import java.util.Map;

/**
 * Bank Class
 * @author (Originally Bullwinkle Moose) - Recreated by Guilherme and Monika
 * @version 2019.04.20
 */
public class Bank {

    public static Map<String, Customer> theBank;  // According to javadocs, public and not final

    /**
     * Default constructor for Bank class. Initializes the HashMap
     */
    Bank(){
        theBank = new HashMap<String, Customer>();
    }

    /**
     * Add a new Customer to the HashMap.
     * @param newCustomer The new element to add to the HashpMap using the account number as the key and the new
     *                    Customer as the value.
     */
    public void addCustomer(final Customer newCustomer){
        theBank.put(newCustomer.getAccount().getAccountNumber(), newCustomer);
    }

    /**
     * Removes an Customer from the HashMap.
     * @param accountNumber accountNumber - The key of the element to remove from the HashMap.
     */
    public void closeAccount(final String accountNumber){
        if (theBank.containsKey(accountNumber)){
            theBank.remove(accountNumber);
        }
    }

    /**
     * Displays the details of a Customer element in the HshMap. Uses Customer.toString() implementation.
     * @param customer the Customer chosen to display.
     */
    public static void displayCustomerInformation(final Customer customer){
        if (theBank.containsKey(customer.getAccount().getAccountNumber())){
            System.out.println(customer.toString());
        }
    }

    /**
     * Displays all elements of the HashMap by using Customer.toString() implementation of each.
     */
    public static void displayAllCustomers(){
        theBank.forEach((key, value) -> System.out.println(value.toString()));
    }

}
