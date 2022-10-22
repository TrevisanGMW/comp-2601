package ca.bcit.comp2601.assignment01;

/**
 * Teacher class
 * This class extends the Person class. It also has an additional instance variable and its accessor method:
 * String specialty and public String getSpecialty().
 * public Teacher (Date born, Name name, String specialty): this constructor throws IllegalPersonException
 * exceptions if born or name is null. Also, it throws an IllegalPersonException exception if specialty is blank
 * (note: null is ok).
 *
 * This class overrides the public String toString() method, which returns a String in one of these two exact formats:
 * a) Alive people example: "Tiger Woods (specialty: mathematics) was born 1975-12-30 and is still alive"
 * b) Dead people example: "Albert Einstein (specialty: mathematics) was born 1879-03-14 and died 1955-04-18"
 * Use the parent's getName() return value, then its getPrettyName() method, and the born/died getYyyyMmDd() method.
 *
 *
 * @author Guilherme Trevisan
 * @version 0.0.1
 * @since 2022-10-10
 */

public class Teacher extends Person{
}
