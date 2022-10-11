package ca.bcit.comp2601.assignment01;

/**
 * Person class
 * This class implements the Comparable interface (details below).
 * This class has instance variables and accessor methods for Date born, Date died, and Name name.
 * It has the following methods:
 * public Person (Date born, Name name): This constructor throws IllegalPersonException exceptions
 *                                       if either born or name is null.
 * public void die(Date dateOfDeath): this method sets the died instance variable to the dateOfDeath provided.
 * public boolean isAlive(): this method returns true if the Person is alive; otherwise returns false.
 * public int compareTo(Person p): this method satisfies the requirements from implementing the Comparable interface.
 * Younger people are "larger". Note: this method must use its born variable's compareTo(Date d) method.
 * This class overrides the public String toString() method, which returns a String in one of these two exact formats:
 * a) Alive people example: "Tiger Woods was born 1975-12-30 and is still alive"
 * b) Dead people example: "Albert Einstein was born 1879-03-14 and died 1955-04-18"
 * Use the name variable's getPrettyName() method, and the born/died getYyyyMmDd() method.
 *
 * @author Guilherme Trevisan
 * @version 0.0.1
 * @since 2022-10-10
 */

public class Person {
}
