package ca.bcit.comp2601.assignment01;

import java.lang.reflect.Array;

/**
 * Date Class
 * @author Guilherme Trevisan
 * @version 0.0.1
 * @since 2022-10-10
 */

public class Date implements Orderable, Comparable{

    private final int year;
    private final int month;
    private final int day;

    private static final int MIN_YEAR = 1;
    private static final int MIN_MONTH = 1;
    private static final int MAX_MONTH = 12;
    private static final int MIN_DAY = 1;
    private static final int MAX_DAY_JMMJAOD = 31;
    private static final int MAX_DAY_AJSN = 30;
    private static final int MAX_DAY_FEB_COMMON = 28;
    private static final int MAX_DAY_FEB_LEAP = MAX_DAY_FEB_COMMON + 1;
    private static final int NUM_TWELVE = 12;
    private static final int NUM_FOUR = 4;
    private static final int YEAR_RANGE_NO_MOD = 1900;
    private static final int YEAR_RANGE_MOD_SIX = 2000;
    private static final int YEAR_RANGE_MOD_TWO = 1800;
    private static final int MONTH_NUM_JANUARY = 1;
    private static final int MONTH_NUM_FEBRUARY = 2;
    private static final int NUM_SIX = 6;
    private static final int NUM_TWO = 2;
    private static final int MONTH_INDEX_OFFICE = -1;

    private static final String[] WEEK_DAYS = {"Saturday",
                                               "Sunday",
                                               "Monday",
                                               "Tuesday",
                                               "Wednesday",
                                               "Thursday",
                                               "Friday"};
    private static final String[] MONTHS = {"January", // 1
                                            "February", // 2
                                            "March", // 3
                                            "April", // 4
                                            "May", // 5
                                            "June", // 6
                                            "July", // 7
                                            "August", // 8
                                            "September", // 9
                                            "October", // 10
                                            "November", // 11
                                            "December"}; // 12

    private static final int[] JFMAMJJASOND =  {0, 1, 4, 4, 0, 2, 5, 0, 3, 6, 1, 4, 6}; // Used to determine weekDay

    /**
     * The constructor allows only years between 1 - CURRENT_YEAR;
     * months 1-12;
     * and days 1-31 (or 30, or 29, or 28: properly)
     * @param day int day
     * @param month int month
     * @param year int year
     */
    public Date(final int day, final int month, final int year)
    {
        // Year Validation
        if (year >= MIN_YEAR) {
            this.year = year;
        }
        else {
            throw new IllegalArgumentException("Invalid year. Value needs to be more than zero.");
        }

        // Month Validation
        if(month >= MIN_MONTH && month <= MAX_MONTH) {
            this.month = month;
        }
        else {
            throw new IllegalArgumentException("Invalid month. Value needs to be between 1 and 12");
        }

        // Day Validation
        final String DAY_ERROR_MESSAGE = "Invalid day. Value outside of the month's range.";
        if(day < MIN_DAY || day > MAX_DAY_JMMJAOD) {
            throw new IllegalArgumentException(DAY_ERROR_MESSAGE);
        }
        else {
            int maximumFebruary;
            if (isLeapYear(year)) {
                maximumFebruary = MAX_DAY_FEB_LEAP;
            }
            else {
                maximumFebruary = MAX_DAY_FEB_COMMON;
            }
            switch (month) {
                case 4, 6, 9, 11:
                    if(day > MAX_DAY_AJSN) {
                        throw new IllegalArgumentException(DAY_ERROR_MESSAGE);
                    }
                    break;
                case 2:
                    if(day > maximumFebruary) {
                        throw new IllegalArgumentException(DAY_ERROR_MESSAGE);
                    }
                    break;
                default:
                    // Do nothing
            }
            this.day = day;
        }
    }

    /**
     * Getter year
     * @return year
     */
    public int getYear() {
        return year;
    }

    /**
     * Getter month
     * @return month
     */
    public int getMonth() {
        return month;
    }

    /**
     * Getter day
     * @return day
     */
    public int getDay() {
        return day;
    }

    /**
     * @return String date formatted as YYYY-MM-DD
     * e.g. 2022-01-01
     */
    public String getYyyyMmDd() {
        return String.format("%04d", year) + "-"  + String.format("%02d", month)  + "-" + String.format("%02d", day);
    }

    /**
     * @return String date as text in the follow format "month DD, YYYY"
     * e.g. "January 01, 2022"
     */
    public String getDateAsText() {
        return MONTHS[month+MONTH_INDEX_OFFICE] + " " + day + ", " + year;
    }

    /**
     * @return day of the week as text.
     * e.g. Monday
     */
    public String getDayOfTheWeek()
    {
        int numModifier = 0;
        if (year >= YEAR_RANGE_NO_MOD && year < YEAR_RANGE_MOD_SIX){
            // Do nothing
        }
        else if (year>= YEAR_RANGE_MOD_SIX)
        {
            numModifier = NUM_SIX;
        }
        else if (year >= YEAR_RANGE_MOD_TWO && year < YEAR_RANGE_NO_MOD)
        {
            numModifier = NUM_TWO;
        }
        else
        {
            // Do nothing
        }

        if (month == MONTH_NUM_JANUARY || month == MONTH_NUM_FEBRUARY)
        {
            numModifier = numModifier+NUM_SIX;
        }


        int lastTwoDigits = Integer.parseInt(Integer.toString(year).substring(2));

        // step 1: calculate the number of twelves in 77: 6
        int numberOfTwelves = 0;
        int lastTwoDigitsCount = lastTwoDigits;
        while (lastTwoDigitsCount>=NUM_TWELVE) {
            lastTwoDigitsCount=lastTwoDigitsCount-NUM_TWELVE;
            numberOfTwelves++;
        }

        // step 2: calculate the remainder from step 1: 77 - 12*6 = 77 - 72 = 5
        int remainder = lastTwoDigits%NUM_TWELVE;

        // step 3: calculate the number of fours in step 2: 5/4 = 1.25, so 1
        int numberOfFours = 0;
        int remainderCount = remainder;
        while (remainderCount>=NUM_FOUR) {
            remainderCount=remainderCount-NUM_FOUR;
            numberOfFours++;
        }

        // step 4: add the day of the month to each step above: 31 + 6 + 5 + 1 = 43
        // step 5: add the month code (for jfmamjjasond: 144025036146): for october it is 1: 43 + 1 = 	44
        int numProcessing = numModifier + day + numberOfTwelves +
                remainder + numberOfFours + (int) Array.get(JFMAMJJASOND, month);

        int numProcessingMod = numProcessing%7;
        // step 6: add the previous five numbers up: 44; mod that number 44 by 7: 44%7 = 2 (44/7 = 6 remainder 2)

        // step 7: sat sun mon tue wed thu fri is 0 1 2 3 4 5 6; our number 2 means October 31, 1977 was monday
        return (String)Array.get(WEEK_DAYS, numProcessingMod);
    }

    /**
     * @param year int year to be tested as leap year
     * @return boolean if it's a leap year, it returns true, else false
     */
    private static boolean isLeapYear(int year)
    {
        boolean isLeap;
        // if the year is divided by 4
        if (year % 4 == 0)
        {
            // if the year is century
            if (year % 100 == 0)
            {
                // if year is divided by 400
                // then it is a leap year
                if (year % 400 == 0)
                    isLeap = true;
                else
                    isLeap = false;
            }

            // if the year is not century
            else
                isLeap = true;
        }
        else
        {
            isLeap = false;
        }
        return isLeap;
    }

    /**
     * Override toString to return getYyyyMmDd
     * @return
     */
    @Override
    public String toString() {
        return getYyyyMmDd();
    }

    /**
     * Catch error?
     * @return
     */
    private static String validate(){
        if(day < MIN_DAY || day > MAX_DAY_JMMJAOD) {
            throw new IllegalArgumentException(DAY_ERROR_MESSAGE);
        }
        else {
            int maximumFebruary;
            if (isLeapYear(year)) {
                maximumFebruary = MAX_DAY_FEB_LEAP;
            }
            else {
                maximumFebruary = MAX_DAY_FEB_COMMON;
            }
            switch (month) {
                case 4, 6, 9, 11:
                    if(day > MAX_DAY_AJSN) {
                        throw new IllegalArgumentException(DAY_ERROR_MESSAGE);
                    }
                    break;
                case 2:
                    if(day > maximumFebruary) {
                        throw new IllegalArgumentException(DAY_ERROR_MESSAGE);
                    }
                    break;
                default:
                    // Do nothing
            }
            this.day = day;
        }
    }

    /**
     * @return
     */
    @Override
    public Orderable next() {
        Date newDate;
        newDate = new Date()
        return null;
    }

    /**
     * @return
     */
    @Override
    public Orderable previous() {
        return null;
    }

    /**
     * Compares this object with the specified object for order.  Returns a
     * negative integer, zero, or a positive integer as this object is less
     * than, equal to, or greater than the specified object.
     *
     * <p>The implementor must ensure {@link Integer#signum
     * signum}{@code (x.compareTo(y)) == -signum(y.compareTo(x))} for
     * all {@code x} and {@code y}.  (This implies that {@code
     * x.compareTo(y)} must throw an exception if and only if {@code
     * y.compareTo(x)} throws an exception.)
     *
     * <p>The implementor must also ensure that the relation is transitive:
     * {@code (x.compareTo(y) > 0 && y.compareTo(z) > 0)} implies
     * {@code x.compareTo(z) > 0}.
     *
     * <p>Finally, the implementor must ensure that {@code
     * x.compareTo(y)==0} implies that {@code signum(x.compareTo(z))
     * == signum(y.compareTo(z))}, for all {@code z}.
     *
     * @param o the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object
     * is less than, equal to, or greater than the specified object.
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException   if the specified object's type prevents it
     *                              from being compared to this object.
     * @apiNote It is strongly recommended, but <i>not</i> strictly required that
     * {@code (x.compareTo(y)==0) == (x.equals(y))}.  Generally speaking, any
     * class that implements the {@code Comparable} interface and violates
     * this condition should clearly indicate this fact.  The recommended
     * language is "Note: this class has a natural ordering that is
     * inconsistent with equals."
     */
    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
