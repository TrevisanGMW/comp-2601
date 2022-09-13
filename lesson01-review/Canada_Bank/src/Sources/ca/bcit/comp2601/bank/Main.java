package ca.bcit.comp2601.bank;

public class Main {
    public static void main(String[] args)
    {
        Name name = new Name("Tiger", "Woods");
        Name name2 = new Name("Albert", "Einstein");
        Date birth = new Date(1975, 12, 30);
        Date birth2 = new Date(1879, 3, 14);
        Date death = new Date(1955, 4, 18);
        Person person1 = new Person(name, birth, null);
        Person person2 = new Person(name2, birth2, death);
//        System.out.println(person1.getDetails());
//        System.out.println(person2.getDetails());

        BankClient bankClient = new BankClient(name2, birth2, death, death, "12345");
        BankAccount bankAccount = new BankAccount(bankClient, 200d, 1337,
                                     "1234567", birth, null);
        System.out.println(bankAccount.deposit(200d));
        System.out.println(bankAccount.getBalanceUsd());
        System.out.println(bankAccount.withdraw(150d));
        System.out.println(bankAccount.getBalanceUsd());





        /**
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