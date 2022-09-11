package ca.bcit.comp2601.bank;

import java.lang.reflect.Array;
import java.util.Calendar;

//2) implement the code and tests for: getDay(), getMonth(), getYear(), getYYYYMMDD() /* returns date such as 2022-09-30 */, and getDayOfTheWeek()
public class Date
{
    private int year;
    private int month;
    private int day;


    private static final int MIN_YEAR = 1;
    private static final int CURRENT_YEAR = Calendar.getInstance().get(Calendar.YEAR);
    private static final int MIN_MONTH = 0;
    private static final int MAX_MONTH = 12;
    private static final int MIN_DAY = 1;
    private static final int MAX_MAX = 31;
    private static final int NUM_TWELVE = 12;
    private static final int NUM_FOUR = 4;
    private static final int YEAR_RANGE_NO_MOD = 1900;
    private static final int YEAR_RANGE_MOD_SIX = 2000;
    private static final int YEAR_RANGE_MOD_TWO = 1800;

    private static final String[] WEEK_DAYS = {"Saturday",
                                               "Sunday",
                                               "Monday",
                                               "Tuesday",
                                               "Wednesday",
                                               "Thursday",
                                               "Friday"};

    private static final int[] JFMAMJJASOND =  {0, 1, 4, 4, 0, 2, 5, 0, 3, 6, 1, 4, 6};

    /**
     * The constructor allows only years between 1 - CURRENT_YEAR;
     * months 1-12;
     * and days 1-31 (or 30, or 29, or 28: properly)
     * @param year
     * @param month
     * @param day
     */
    public Date(int year, int month, int day)
    {
        if (year >= MIN_YEAR && year <= CURRENT_YEAR)
        {
            this.year = year;
        }

        if(month >= MIN_MONTH && month <= MAX_MONTH)
        {
            this.month = month;
        }
        else
        {
            throw new IllegalArgumentException("Invalid month. Value needs to be between 1 and 12");
        }

        if(day >= MIN_DAY && day <= MAX_MAX)
        {
            this.day = day;
        }
        else
        {
            throw new IllegalArgumentException("Invalid day. Value outside of the month's range.");
        }


    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public String getYyyyMmDd() {
        return String.format("%04d", year) + "-"  + String.format("%02d", month)  + "-" + String.format("%02d", day);
    }

    public String getDayOfTheWeek()
    {
        int numExceptions = 0;
        if (year >= YEAR_RANGE_NO_MOD && year < YEAR_RANGE_MOD_SIX){
            // Do nothing
        }
        else if (year>= YEAR_RANGE_MOD_SIX)
        {
            numExceptions = 6;
        }
        else if (year >= YEAR_RANGE_MOD_TWO && year < YEAR_RANGE_NO_MOD)
        {
            numExceptions = 2;
        }
        else
        {
            // DO nothing
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
        int numProcessing = numExceptions + day + numberOfTwelves +
                remainder + numberOfFours + (int)Array.get(JFMAMJJASOND, month);

        int numProcessingMod = numProcessing%7;
        // step 6: add the previous five numbers up: 44; mod that number 44 by 7: 44%7 = 2 (44/7 = 6 remainder 2)

        // step 7: sat sun mon tue wed thu fri is 0 1 2 3 4 5 6; our number 2 means October 31, 1977 was monday
        System.out.println(numProcessing);
        return (String)Array.get(WEEK_DAYS, numProcessingMod);
    }

    public static boolean isisLeapYear(int year)
    {
        boolean isLeap = false;

        // if the year is divided by 4
        if (year % 4 == 0)
        {

            // if the year is century
            if (year % 100 == 0)
            {

                // if year is divided by 400
                // then it is a isLeap year
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


}
