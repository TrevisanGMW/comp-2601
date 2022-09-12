package ca.bcit.comp2601.bank;


/**
 * Person (has a Name and a birthDate and a deathDate [which can be null];
 * has a getDetails() method which returns a String in the exact format of
 * "Tiger Woods (alive) was born on tuesday, December 30, 1975!" or
 * “Albert Einstein (died monday, April 18, 1955) was born on friday, March 14, 1879!”.
 *
 * Instance variables, constructor arguments, accessor methods for:
 * name
 * date born
 * date died
 *
 * Methods:
 * getDetails()
 * isAlive()
 *
 */
public class Person
{
    private final Name name;
    private final Name birthDate;
    private final Name deathDate; // can be null

    public Person(Name name, Name birthDate, Name deathDate) {
        this.name = name;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
    }
}
