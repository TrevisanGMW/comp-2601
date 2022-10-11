package ca.bcit.comp2601.assignment01;

/**
 * School class
 * There is one instance variable for this class: a List of Person references.
 * Use an initializer block to create an empty ArrayList and assign it to your List variable.
 * public void register(Person p): this method throws an IllegalPersonException if the argument is null. Otherwise,
 * the Person is added to the end of your List.
 * public void printRoster(): this method uses a method reference to print out all the people
 * (i.e. triggering a call to their respective toString() methods). public void printAgesAndYears():
 * this method declares a local variable w of type Writeable, which takes three parameters: fullName, yearBorn,
 * and maxYear; for example: "Tiger Woods", 1975, 2022, or "Albert Einstein", 1879, 1955. It uses a lambda
 * expression to loop through the integers from yearBorn to maxYear and prints the person's name and age for
 * each year of life. For example (use all the years; some were omitted here for brevity):
 *
 * Finally, loop through your List of Person references and use a lambda expression to determine the argument
 * values to pass to w's printData() method - fullName, yearBorn, and maxYear – as follows:
 * 1. fullName: the Person's getName().getPrettyName()
 * 2. yearBorn: the Person's getDateOfBirth().getYear()
 * 3. maxYear: the current year (if alive), or the Person's getDateOfDeath().getYear() (if not alive).
 *
 * @author Guilherme Trevisan
 * @version 0.0.1
 * @since 2022-10-10
 */

public class School {
}
