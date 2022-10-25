package ca.bcit.comp2601.assignment01;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Date Class
 *
 * @author Guilherme Trevisan
 * @version 0.0.1
 * @since 2022-10-10
 */

public class Date implements Orderable, Comparable {

    private static final int MIN_YEAR;
    private static final int MIN_MONTH;
    private static final int MAX_MONTH;
    private static final int MIN_DAY;
    private static final int MAX_DAY_JMMJAOD;
    private static final int MAX_DAY_AJSN;
    private static final int MAX_DAY_FEB_COMMON;
    private static final int MAX_DAY_FEB_LEAP;
    private static final int NUM_TWELVE;
    private static final int NUM_FOUR;
    private static final int YEAR_RANGE_NO_MOD;
    private static final int YEAR_RANGE_MOD_SIX;
    private static final int YEAR_RANGE_MOD_TWO;
    private static final int MONTH_NUM_JANUARY;
    private static final int MONTH_NUM_FEBRUARY;
    private static final int YEAR_RANGE_MOD_SIX_RESULT;
    private static final int YEAR_RANGE_NO_MOD_RESULT;
    private static final int MONTH_INDEX_OFFSET;
    private static final int WEEKDAY_DEFAULT_MODIFIER;
    private static final int LEAP_DIVISIBLE_CONDITION_ONE;
    private static final int LEAP_DIVISIBLE_CONDITION_TWO;
    private static final int LEAP_CENTURY_CHECK;
    private static final int LEAP_NEGATIVE_RESULT;
    private static final int ORDERABLE_NEXT_OFFSET;
    private static final int ORDERABLE_PREVIOUS_OFFSET;
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
        NUM_TWELVE = 12;
        NUM_FOUR = 4;
        YEAR_RANGE_NO_MOD = 1900;
        YEAR_RANGE_MOD_SIX = 2000;
        YEAR_RANGE_MOD_TWO = 1800;
        MONTH_NUM_JANUARY = 1;
        MONTH_NUM_FEBRUARY = 2;
        YEAR_RANGE_MOD_SIX_RESULT = 6;
        YEAR_RANGE_NO_MOD_RESULT = 2;
        MONTH_INDEX_OFFSET = -1;
        WEEKDAY_DEFAULT_MODIFIER = 0;
        LEAP_DIVISIBLE_CONDITION_ONE = 4;
        LEAP_DIVISIBLE_CONDITION_TWO = 400;
        LEAP_CENTURY_CHECK = 100;
        LEAP_NEGATIVE_RESULT = 0;
        ORDERABLE_NEXT_OFFSET = 1;
        ORDERABLE_PREVIOUS_OFFSET = -1;
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

    private final int year;
    private final int month;
    private final int day;

    /**
     * The constructor allows only years between 1 - CURRENT_YEAR;
     * months 1-12;
     * and days 1-31 (or 30, or 29, or 28: properly)
     *
     * @param day   int day
     * @param month int month
     * @param year  int year
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
     * @param year int year to be tested as leap year
     * @return boolean if it's a leap year, it returns true, else false
     */
    private static boolean isLeapYear(int year) {
        boolean isLeap;
        // if the year is divided by 4
        if (year % LEAP_DIVISIBLE_CONDITION_ONE == LEAP_NEGATIVE_RESULT) {
            // if the year is century
            if (year % LEAP_CENTURY_CHECK == LEAP_NEGATIVE_RESULT) {
                // if year is divided by 400
                // then it is a leap year
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
     *
     * @param year year number (needs to be more than zero)
     * @return valid year
     */
    private static int validateYear(final int year) {
        if (year >= MIN_YEAR) {
            return year;
        } else {
            throw new IllegalArgumentException("Invalid year. Value needs to be more than zero.");
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
            throw new IllegalArgumentException("Invalid month. Value needs to be between 1 and 12");
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
        final String DAY_ERROR_MESSAGE = "Invalid day. Value outside of the month's range.";
        if (day < MIN_DAY || day > MAX_DAY_JMMJAOD) {
            throw new IllegalArgumentException(DAY_ERROR_MESSAGE);
        } else {
            int maximumFebruary;
            if (isLeapYear(year)) {
                maximumFebruary = MAX_DAY_FEB_LEAP;
            } else {
                maximumFebruary = MAX_DAY_FEB_COMMON;
            }

            if (Arrays.asList(MONTHS_LOW_MAX_DAYS).contains(month)) {
                if (day > MAX_DAY_AJSN) {
                    throw new IllegalArgumentException(DAY_ERROR_MESSAGE);
                } else if (MONTH_NUM_FEBRUARY == month) {
                    if (day > maximumFebruary) {
                        throw new IllegalArgumentException(DAY_ERROR_MESSAGE);
                    }
                } else {
                    // Do nothing
                }
            }
            return day;
        }
    }

    /**
     * Gets the maximum day value depending on the provided month/year
     * @param month month used to check
     * @param year year used to check (leap years are different)
     * @return maximum day for the provided month
     */
    private static int getMaxDayFromMonth(final int month, final int year) {

        int maximumFebruary;
        if (isLeapYear(year)) {
            maximumFebruary = MAX_DAY_FEB_LEAP;
        } else {
            maximumFebruary = MAX_DAY_FEB_COMMON;
        }

        if (Arrays.asList(MONTHS_LOW_MAX_DAYS).contains(month)) {
            return MAX_DAY_AJSN;
        } else if (MONTH_NUM_FEBRUARY == month) {
            return maximumFebruary;
        } else {
            return MAX_DAY_JMMJAOD;
        }
    }


    /**
     * Getter year
     *
     * @return year
     */
    public int getYear() {
        return year;
    }

    /**
     * Getter month
     *
     * @return month
     */
    public int getMonth() {
        return month;
    }

    /**
     * Getter day
     *
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
        return String.format("%04d", year) + "-" + String.format("%02d", month) + "-" + String.format("%02d", day);
    }

    /**
     * @return String date as text in the follow format "month DD, YYYY"
     * e.g. "January 01, 2022"
     */
    public String getDateAsText() {
        return MONTHS[month + MONTH_INDEX_OFFSET] + " " + day + ", " + year;
    }

    /**
     * @return day of the week as text.
     * e.g. Monday
     */
    public String getDayOfTheWeek() {
        int numModifier = WEEKDAY_DEFAULT_MODIFIER;
        if (year >= YEAR_RANGE_NO_MOD && year < YEAR_RANGE_MOD_SIX) {
            // Do nothing
        } else if (year >= YEAR_RANGE_MOD_SIX) {
            numModifier = YEAR_RANGE_MOD_SIX_RESULT;
        } else if (year >= YEAR_RANGE_MOD_TWO && year < YEAR_RANGE_NO_MOD) {
            numModifier = YEAR_RANGE_NO_MOD_RESULT;
        } else {
            // Do nothing
        }

        if (month == MONTH_NUM_JANUARY || month == MONTH_NUM_FEBRUARY) {
            numModifier = numModifier + YEAR_RANGE_MOD_SIX_RESULT;
        }


        int lastTwoDigits = Integer.parseInt(Integer.toString(year).substring(2));

        // step 1: calculate the number of twelves in 77: 6
        int numberOfTwelves = 0;
        int lastTwoDigitsCount = lastTwoDigits;
        while (lastTwoDigitsCount >= NUM_TWELVE) {
            lastTwoDigitsCount = lastTwoDigitsCount - NUM_TWELVE;
            numberOfTwelves++;
        }

        // step 2: calculate the remainder from step 1: 77 - 12*6 = 77 - 72 = 5
        int remainder = lastTwoDigits % NUM_TWELVE;

        // step 3: calculate the number of fours in step 2: 5/4 = 1.25, so 1
        int numberOfFours = 0;
        int remainderCount = remainder;
        while (remainderCount >= NUM_FOUR) {
            remainderCount = remainderCount - NUM_FOUR;
            numberOfFours++;
        }

        // step 4: add the day of the month to each step above: 31 + 6 + 5 + 1 = 43
        // step 5: add the month code (for jfmamjjasond: 144025036146): for october it is 1: 43 + 1 = 	44
        int numProcessing = numModifier + day + numberOfTwelves +
                remainder + numberOfFours + (int) Array.get(WEEKDAY_MODIFIERS_JFMAMJJASOND, month);

        int numProcessingMod = numProcessing % 7;
        // step 6: add the previous five numbers up: 44; mod that number 44 by 7: 44%7 = 2 (44/7 = 6 remainder 2)

        // step 7: sat sun mon tue wed thu fri is 0 1 2 3 4 5 6; our number 2 means October 31, 1977 was monday
        return (String) Array.get(WEEK_DAYS, numProcessingMod);
    }

    /**
     * Override toString to return getYyyyMmDd
     *
     * @return
     */
    @Override
    public String toString() {
        return getYyyyMmDd();
    }

    /**
     * @return
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
     * @return
     */
    @Override
    public Date previous() {
        Date previousDate;
        try {
            previousDate = new Date(getDay() + ORDERABLE_PREVIOUS_OFFSET, getMonth(), getYear());
        } catch (Exception eOne) {
            try {
                previousDate = new Date(getMaxDayFromMonth(getMonth() + ORDERABLE_PREVIOUS_OFFSET, getYear()),
                        getMonth() + ORDERABLE_PREVIOUS_OFFSET, getYear());
            } catch (Exception eTwo) {
                previousDate = new Date(MAX_DAY_JMMJAOD, MAX_MONTH, getYear() + ORDERABLE_PREVIOUS_OFFSET);
            }
        }
        return previousDate;
    }

    /**
     * @param o the object to be compared.
     * @return
     */
    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
