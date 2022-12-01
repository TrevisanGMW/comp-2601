package ca.bcit.comp2601.assignment02;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Date Class - Copied from Assignment 01 (Used for Unit Testing)
 * @author Guilherme Trevisan, Monika Szucs
 * @version 0.0.2
 * @since 2022-10-10
 */
public class Date implements Orderable, Comparable {

    private final int year;
    private final int month;
    private final int day;

    private static final int MIN_YEAR;
    private static final int MIN_MONTH;
    private static final int MAX_MONTH;
    private static final int MIN_DAY;
    private static final int MAX_DAY_JMMJAOD;
    private static final int MAX_DAY_AJSN;
    private static final int MAX_DAY_FEB_COMMON;
    private static final int MAX_DAY_FEB_LEAP;
    private static final int WEEKDAY_TWELVES_CHECK;
    private static final int WEEKDAY_COUNTERS_START;
    private static final int WEEKDAY_FOURS_CHECK;
    private static final int WEEKDAY_SUBSTRING_EXTRACTION;
    private static final int WEEKDAY_MOD_OPERATION_VALUE;
    private static final int SEVENTEENTH_CENTURY_START;
    private static final int EIGHTEENTH_CENTURY_START;
    private static final int NINETEENTH_CENTURY_START;
    private static final int TWENTIETH_CENTURY_START;
    private static final int TWENTY_FIRST_CENTURY_START;
    private static final int TWENTY_SECOND_CENTURY_START;
    private static final int MONTH_NUM_JANUARY;
    private static final int MONTH_NUM_FEBRUARY;
    private static final int MODIFIER_SEVENTEENTH_EIGHTEENTH;
    private static final int MODIFIER_EIGHTEENTH_NINETEENTH;
    private static final int MODIFIER_NINETEENTH_TWENTIETH;
    private static final int MODIFIER_TWENTIETH_FIRST_SECOND;
    private static final int MODIFIER_TWENTY_SECOND_AHEAD;
    private static final int MONTH_INDEX_OFFSET;
    private static final int MODIFIER_DEFAULT_VALUE;
    private static final int LEAP_DIVISIBLE_CONDITION_ONE;
    private static final int LEAP_DIVISIBLE_CONDITION_TWO;
    private static final int LEAP_CENTURY_CHECK;
    private static final int LEAP_NEGATIVE_RESULT;
    private static final int ORDERABLE_NEXT_OFFSET;
    private static final int ORDERABLE_PREVIOUS_OFFSET;
    private static final int COMPARABLE_LARGER;
    private static final int COMPARABLE_EQUAL;
    private static final int COMPARABLE_SMALLER;
    private static final int[] WEEKDAY_MODIFIERS_JFMAMJJASOND;
    private static final int[] MONTHS_LOW_MAX_DAYS;
    private static final String[] WEEK_DAYS;
    private static final String[] MONTHS;

    static {
        MIN_YEAR = 1;
        MIN_MONTH = 1;
        MAX_MONTH = 12;
        MIN_DAY = 1;
        MAX_DAY_JMMJAOD = 31;
        MAX_DAY_AJSN = 30;
        MAX_DAY_FEB_COMMON = 28;
        MAX_DAY_FEB_LEAP = MAX_DAY_FEB_COMMON + 1;
        WEEKDAY_TWELVES_CHECK = 12;
        WEEKDAY_COUNTERS_START = 0;
        WEEKDAY_FOURS_CHECK = 4;
        WEEKDAY_SUBSTRING_EXTRACTION = 2;
        WEEKDAY_MOD_OPERATION_VALUE = 7;
        SEVENTEENTH_CENTURY_START = 1600;
        EIGHTEENTH_CENTURY_START = 1700;
        NINETEENTH_CENTURY_START = 1800;
        TWENTIETH_CENTURY_START = 1900;
        TWENTY_FIRST_CENTURY_START = 2000;
        TWENTY_SECOND_CENTURY_START = 2100;
        MONTH_NUM_JANUARY = 1;
        MONTH_NUM_FEBRUARY = 2;
        MODIFIER_SEVENTEENTH_EIGHTEENTH = 6;
        MODIFIER_EIGHTEENTH_NINETEENTH = 4;
        MODIFIER_NINETEENTH_TWENTIETH = 2;
        MODIFIER_TWENTIETH_FIRST_SECOND = 6;
        MODIFIER_TWENTY_SECOND_AHEAD = 4;
        MONTH_INDEX_OFFSET = -1;
        MODIFIER_DEFAULT_VALUE = 0;
        LEAP_DIVISIBLE_CONDITION_ONE = 4;
        LEAP_DIVISIBLE_CONDITION_TWO = 400;
        LEAP_CENTURY_CHECK = 100;
        LEAP_NEGATIVE_RESULT = 0;
        ORDERABLE_NEXT_OFFSET = 1;
        ORDERABLE_PREVIOUS_OFFSET = -1;
        COMPARABLE_LARGER = 1;
        COMPARABLE_EQUAL = 0;
        COMPARABLE_SMALLER = -1;
        WEEK_DAYS = new String[]{"Saturday",
                                 "Sunday",
                                 "Monday",
                                 "Tuesday",
                                 "Wednesday",
                                 "Thursday",
                                 "Friday"};
        MONTHS = new String[]{"January", // 1
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
        WEEKDAY_MODIFIERS_JFMAMJJASOND = new int[]{0, 1, 4, 4, 0, 2, 5, 0, 3, 6, 1, 4, 6};
        MONTHS_LOW_MAX_DAYS = new int[]{4, 6, 9, 11};
    }

    /**
     * The constructor allows only years above one;
     * months 1-12;
     * and days 1-31 (or 30, or 29, or 28: properly)
     * @param day   day number
     * @param month month number
     * @param year  year number (cannot be zero)
     */
    public Date(final int day, final int month, final int year) {
        // Year Validation
        this.year = validateYear(year);

        // Month Validation
        this.month = validateMonth(month);

        // Day Validation
        this.day = validateDay(day, month, year);
    }

    /**
     * Checks if year is a leap year or not
     * @param year year to be tested as leap year
     * @return boolean if it's a leap year, it returns true, else false
     */
    private static boolean isLeapYear(int year) {
        boolean isLeap;
        // if the year is divided by 4
        if (year % LEAP_DIVISIBLE_CONDITION_ONE == LEAP_NEGATIVE_RESULT) {
            // if the year is century
            if (year % LEAP_CENTURY_CHECK == LEAP_NEGATIVE_RESULT) {
                // if year is divided by 400 -> then it is a leap year
                if (year % LEAP_DIVISIBLE_CONDITION_TWO == LEAP_NEGATIVE_RESULT)
                    isLeap = true;
                else
                    isLeap = false;
            }
            // if the year is not century
            else
                isLeap = true;
        } else {
            isLeap = false;
        }
        return isLeap;
    }

    /**
     * Validates year input
     * @param year year number (needs to be more than zero)
     * @return valid year
     */
    private static int validateYear(final int year) {
        if (year >= MIN_YEAR) {
            return year;
        } else {
            throw new IllegalArgumentException("invalid year");
        }
    }

    /**
     * Validates month input
     *
     * @param month month number to validate (must be between 1 and 12)
     * @return valid month
     */
    private static int validateMonth(final int month) {
        if (month >= MIN_MONTH && month <= MAX_MONTH) {
            return month;
        } else {
            throw new IllegalArgumentException("invalid month");
        }
    }

    /**
     * Validates day input (requires month and year to check if day is available)
     *
     * @param day   day number to validate
     * @param month month number used to detect day limits
     * @param year  year used to determine leap years
     * @return valid day
     * @throws IllegalArgumentException if provided day doesn't work
     */
    private static int validateDay(final int day, final int month, final int year) {
        final String DAY_ERROR_MESSAGE = "invalid day of the month";
        if (day < MIN_DAY || day > MAX_DAY_JMMJAOD) {
            throw new IllegalArgumentException(DAY_ERROR_MESSAGE);
        } else {
            int maximumFebruary;
            if (isLeapYear(year)) {
                maximumFebruary = MAX_DAY_FEB_LEAP;
            } else {
                maximumFebruary = MAX_DAY_FEB_COMMON;
            }

            if (intArrayContains(MONTHS_LOW_MAX_DAYS, month)) {
                if (day > MAX_DAY_AJSN) {
                    throw new IllegalArgumentException(DAY_ERROR_MESSAGE);
                }
            } else if (MONTH_NUM_FEBRUARY == month && day > maximumFebruary) {
                throw new IllegalArgumentException(DAY_ERROR_MESSAGE);
            }
            return day;
        }
    }

    /**
     * Method to check if an int array contains a specified value
     * (I know this would likely live inside a utility class, but I kept it here to save time)
     * @param arr array to check
     * @param key value to look for
     * @return true if it contains
     */
    public static boolean intArrayContains(final int[] arr, final int key) {
        return Arrays.stream(arr).anyMatch(i -> i == key);
    }

    /**
     * Gets the maximum day value depending on the provided month/year
     * @param month month used to check
     * @param year year used to check (leap years are different)
     * @return maximum day for the provided month
     */
    private static int getNumberOfDaysPerMonth(final int month, final int year) {

        int maximumFebruary;
        if (isLeapYear(year)) {
            maximumFebruary = MAX_DAY_FEB_LEAP;
        } else {
            maximumFebruary = MAX_DAY_FEB_COMMON;
        }

        if (intArrayContains(MONTHS_LOW_MAX_DAYS, month)) {
            return MAX_DAY_AJSN;
        } else if (MONTH_NUM_FEBRUARY == month) {
            return maximumFebruary;
        } else {
            return MAX_DAY_JMMJAOD;
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
     * Get YYYY-MM-DD format
     * @return String date formatted as YYYY-MM-DD (2022-01-01)
     * e.g. 2022-01-01
     */
    public String getYyyyMmDd() {
        return String.format("%04d", year) + "-" + String.format("%02d", month) + "-" + String.format("%02d", day);
    }

    /**
     * Getter Date as Text
     * @return String date as text in the follow format "month DD, YYYY"
     * e.g. "January 01, 2022"
     */
    public String getDateAsText() {
        return MONTHS[month + MONTH_INDEX_OFFSET] + " " + day + ", " + year;
    }

    /**
     * Gets the modifier necessary to calculate weekday (Separated into another function to reduce complexity)
     * All dates in the 1600s: add 6
     * All dates in the 1700s: add 4
     * All dates in the 1800s: add 2
     * All dates in the 2000s: add 6
     * All dates in the 2100s: add 4
     * @param month month number
     * @param year year number
     * @return correct modifier
     */
    private static int getWeekdayModifier(final int month, final int year){
        int numModifier;
        if (year >= SEVENTEENTH_CENTURY_START && year < EIGHTEENTH_CENTURY_START) { // 1600 to 1700
            numModifier = MODIFIER_SEVENTEENTH_EIGHTEENTH;
        } else if (year >= EIGHTEENTH_CENTURY_START && year < NINETEENTH_CENTURY_START) { // 1700 to 1800
            numModifier = MODIFIER_EIGHTEENTH_NINETEENTH;
        } else if (year >= NINETEENTH_CENTURY_START && year < TWENTIETH_CENTURY_START) { // 1800 to 1900
            numModifier = MODIFIER_NINETEENTH_TWENTIETH;
        } else if (year >= TWENTIETH_CENTURY_START && year < TWENTY_FIRST_CENTURY_START) { // 1900 to 2000
            numModifier = MODIFIER_DEFAULT_VALUE;
        } else if (year >= TWENTY_FIRST_CENTURY_START && year < TWENTY_SECOND_CENTURY_START) { // 2000 to 2100
            numModifier = MODIFIER_TWENTIETH_FIRST_SECOND;
        } else if (year >= TWENTY_SECOND_CENTURY_START) { // 2100+
            numModifier = MODIFIER_TWENTY_SECOND_AHEAD;
        } else {
            numModifier = MODIFIER_DEFAULT_VALUE;
        }

        if (isLeapYear(year) && (month == MONTH_NUM_JANUARY || month == MONTH_NUM_FEBRUARY)){
            numModifier = numModifier + MODIFIER_SEVENTEENTH_EIGHTEENTH;
        }
        return numModifier;
    }

    /**
     * Getter Day of the Week
     * @return day of the week as text
     * e.g. Monday
     */
    public String getDayOfTheWeek() {
        int numModifier;
        numModifier = getWeekdayModifier(month, year);

        int lastTwoDigits = Integer.parseInt(Integer.toString(year).substring(WEEKDAY_SUBSTRING_EXTRACTION));

        // Step 1: Only look at the last two digits of the year and determine how many twelves fit in it:
        int numberOfTwelves = WEEKDAY_COUNTERS_START;
        int lastTwoDigitsCount = lastTwoDigits;
        while (lastTwoDigitsCount >= WEEKDAY_TWELVES_CHECK) {
            lastTwoDigitsCount = lastTwoDigitsCount - WEEKDAY_TWELVES_CHECK;
            numberOfTwelves++;
        }

        // Step 2: Determine the remainder of step 1's result:
        int remainder = lastTwoDigits % WEEKDAY_TWELVES_CHECK;

        // Step 3: Determine how many fours fit into the remainder (step 2's result):
        int numberOfFours = WEEKDAY_COUNTERS_START;
        int remainderCount = remainder;
        while (remainderCount >= WEEKDAY_FOURS_CHECK) {
            remainderCount = remainderCount - WEEKDAY_FOURS_CHECK;
            numberOfFours++;
        }

        // Step 4: Add the day of the month:
        // Step 5: Add the month code from the table below:
        int numProcessing = numModifier + day + numberOfTwelves +
                remainder + numberOfFours + getCodeForMonth(month);

        int numProcessingMod = numProcessing % WEEKDAY_MOD_OPERATION_VALUE;
        // Step 6: Add the numbers, and then mod by 7

        // step 7: sat sun mon tue wed thu fri is 0 1 2 3 4 5 6; our number 2 means October 31, 1977 was monday
        return (String) Array.get(WEEK_DAYS, numProcessingMod);
    }

    /**
     * Gets Month Code used to determine the weekday
     * @param month number of the month (only 1 to 12)
     * @return month code
     */
    private static int getCodeForMonth(int month){
        return (int) Array.get(WEEKDAY_MODIFIERS_JFMAMJJASOND, month);
    }

    /**
     * Override toString to return getYyyyMmDd
     * @return String date formatted as YYYY-MM-DD (2022-01-01)
     */
    @Override
    public String toString() {
        return getYyyyMmDd();
    }

    /**
     * Next returns the next date, for example 2022-01-02 becomes 2022-01-03
     * @return the next date
     */
    @Override
    public Date next() {
        Date nextDate;
        try {
            nextDate = new Date(getDay() + ORDERABLE_NEXT_OFFSET, getMonth(), getYear());
        } catch (Exception eOne) {
            try {
                nextDate = new Date(MIN_DAY, getMonth() + ORDERABLE_NEXT_OFFSET, getYear());
            } catch (Exception eTwo) {
                nextDate = new Date(MIN_DAY, MIN_MONTH, getYear() + ORDERABLE_NEXT_OFFSET);
            }
        }
        return nextDate;
    }

    /**
     * Previous returns previous date, for example 2022-01-02 becomes 2022-01-01
     * @return previous date
     * @throws IllegalArgumentException in case the previous year ends up being less than 0
     */
    @Override
    public Date previous() {
        Date previousDate;
        try {
            previousDate = new Date(getDay() + ORDERABLE_PREVIOUS_OFFSET, getMonth(), getYear());
        } catch (Exception eOne) {
            try {
                previousDate = new Date(getNumberOfDaysPerMonth(getMonth() + ORDERABLE_PREVIOUS_OFFSET, getYear()),
                        getMonth() + ORDERABLE_PREVIOUS_OFFSET, getYear());
            } catch (Exception eTwo) {
                previousDate = new Date(MAX_DAY_JMMJAOD, MAX_MONTH, getYear() + ORDERABLE_PREVIOUS_OFFSET);
            }
        }
        return previousDate;
    }

    /**
     * Compares dates (not an override, just a method for the compareTo object)
     * @param d (aka "that") another Date object to compare with current (this)
     * @return later dates are larger
     */
    public int compareTo(Date d) {
        if (this.getYear() != d.getYear()) {
            return (this.getYear() < d.getYear() ? COMPARABLE_SMALLER : COMPARABLE_LARGER);
        }

        if (this.getMonth() != d.getMonth()) {
            return (this.getMonth() < d.getMonth() ? COMPARABLE_SMALLER : COMPARABLE_LARGER);
        }

        if (this.getDay() != d.getDay()) {
            return (this.getDay() < d.getDay() ? COMPARABLE_SMALLER : COMPARABLE_LARGER);
        }
        return COMPARABLE_EQUAL;
    }

    /**
     * Default compareTo override
     * @param o the object to be compared (Date objects)
     * @return larger if later date, equal if different objects or incompatible
     */
    @Override
    public int compareTo(Object o) {
        if (o == null){
            return COMPARABLE_SMALLER;
        }
        else if (this == o){
            return COMPARABLE_EQUAL;
        }
        if (o instanceof Date){
            Date d1;
            d1 = (Date)o;
            return compareTo(d1);
        } else {
            return COMPARABLE_EQUAL;
        }
    }
}

