package ca.bcit.comp2601.bank;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args)
    {


        /**
         *      Manual Tests:
         *
         *         Name tigerName = new Name("Tiger", "Woods");
         *         Name albertName = new Name("Albert", "Einstein");
         *         Date birth = new Date(1975, 12, 30);
         *         Date birth2 = new Date(1879, 3, 14);
         *         Date death = new Date(1955, 4, 18);
         *         Person person1 = new Person(tigerName, birth, null);
         *         Person person2 = new Person(albertName, birth, null);
         *         Person albert = new Person(albertName, birth2, death);
         *         System.out.println(person1.getDetails());
         *         System.out.println(person2.getDetails());
         *
         *         BankClient bankClient = new BankClient(albertName, birth2, death, death, "12345");
         *         BankClient bankClient2 = new BankClient(albertName, birth2, death, death, "12346");
         *         BankClient bankClient3 = new BankClient(albertName, birth2, death, death, "12347");
         *         BankAccount bankAccount = new BankAccount(bankClient, 15d, 1337,
         *                                      "1234567", birth, null);
         *
         *         BankAccount bankAccount2 = new BankAccount(bankClient2, 150d, 1337,
         *                                      "1234568", birth, null);
         *         BankAccount bankAccount3 = new BankAccount(bankClient3, 1500d, 1337,
         *                                      "1234569", birth, null);
         *
         *         System.out.println(bankAccount.deposit(200d));
         *         System.out.println(bankAccount.getBalanceUsd());
         *         System.out.println(bankAccount.withdraw(150d));
         *         System.out.println(bankAccount.getBalanceUsd());
         *         ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
         *         accounts.add(bankAccount);
         *         Bank bank = new Bank(albert, accounts);
         *         bank.addAccount(bankAccount2);
         *         bank.addAccount(bankAccount3);
         *
         *
         *         BankAccount[] bankAccounts = bank.getAllAccounts();
         *         System.out.println();
         *         System.out.println(Arrays.toString(bankAccounts));
         *
         *         System.out.println(bank.getMaxAccount().getBalanceUsd());
         *         System.out.println(bank.getAccountFor("12346").getBalanceUsd());
         *
         *
         *         Date date = new Date(1977, 10, 31);
         *         Date date = new Date(2021, 03, 15);
         *         System.out.println(date.getDayOfTheWeek());
         *
         *         Name name = new Name("First", "Last");
         *         Name name = new Name("ThisIsALongNameWithMoreThanFortyFiveCharacters", "wOoDs");
         *         System.out.println(name.getInitials());
         *         System.out.println(name.getFullName());
         *         System.out.println(name.getFullName());
         *         Date date = new Date(1989, 05, 15);
         *         System.out.println(date.getYyyyMmDd());
         *
         *         Date date = new Date(2021, 03, 15);
         *         System.out.println("Invalid name. It cannot be null.".startsWith("Invalid name"));
         */

    }
}