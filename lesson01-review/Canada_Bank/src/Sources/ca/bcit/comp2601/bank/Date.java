package ca.bcit.comp2601.bank;

public class Date
{
    private int year;
    private int month;
    private int day;

    public Date(int year, int month, int day)
    {

        this.year = year;

        if(month > 0 && month < 13)
        {
            this.month = month;
        }
        else
        {
            throw new IllegalArgumentException("Invalid month");
        }

        if(day > 0 && day < 32)
        {
            this.day = day;
        }
        else
        {
            throw new IllegalArgumentException("Invalid day");
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



}
