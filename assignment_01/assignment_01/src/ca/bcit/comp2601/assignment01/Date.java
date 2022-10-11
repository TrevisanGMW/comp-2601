package ca.bcit.comp2601.assignment01;

/**
 * Date Class
 *
 * This class implements the Orderable and the Comparable interfaces (details below).
 * This class has final instance variables, constructor arguments, and accessor methods for int day, int month,
 * and int year. It has the following methods:
 * public Date(int day, int month, int year): This constructor throws IllegalArgumentException exceptions if the
 * year is 0, if the month is not 1 – 12 (remember, though, to avoid using magic numbers), or if the day is not
 * appropriate for the month (e.g. February has only 28 days, February has 29 days in leap years, March has 31 days,
 * April has 30 days, etc…).
 *
 * public String getYyyyMmDd(): this method returns a String representation of the Date in "yyyy-mm-dd" format
 * (e.g. Christmas Day 2032 returns "2032-12-25").
 * This class overrides the public String toString() method, which returns the value from its own public
 * String getYyyyMmDd() method.
 *
 * public Date previous() and public Date next(): these two methods satisfy the requirements from implementing the
 * Orderable interface. If the current date were January 1 2000, then previous() must return December 31 1999;
 * next() would return January 2 2000, etc….
 *
 * public int compareTo(Date d): this method satisfies the requirements from implementing the Comparable interface.
 * Later dates are "larger".
 *
 * public String getDayOfTheWeek(): this method determines and returns the day of the week for a given date.
 * It must use the algorithm given here. It could be useful to create some private methods (e.g. private int
 * getNumberOfDaysPerMonth(int month, int year), etc…). Here is the algorithm you must implement:
 *
 * This method returns the day of the week (e.g. "Wednesday") for a specified date (e.g. October 31, 2012).
 * It must make use of a private method private boolean isLeapYear() (See: http://en.wikipedia.org/wiki/Leap_year)
 * This method returns true (e.g. for 2000, 2024, 2028, etc…) or false (e.g. for 1900, 2023, etc…) depending on
 * whether a year is a leap year.
 *
 * See PDF for full algorithm description
 *
 * @author Guilherme Trevisan
 * @version 0.0.1
 * @since 2022-10-10
 */

public class Date {
}
