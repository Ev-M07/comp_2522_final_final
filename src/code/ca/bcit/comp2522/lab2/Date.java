package ca.bcit.comp2522.lab2;

public class Date
{
    private static final int CURRENT_YEAR = 2026;
    private static final int MAX_MONTH    = 12;
    private static final int MIN_MONTH    = 1;
    private static final int MIN_DAY      = 1;
    private static final int MAX_DAY      = 31;

    private final int year;
    private final int month;
    private final int day;

    Date(final int year,
         final int month,
         final int day)
    {
        validateYear(year);
        validateMonth(month);
        validateDay(day);

        this.year  = year;
        this.month = month;
        this.day   = day;

    }

    public int getYear()
    {
       return year;
    }

    public int getMonth()
    {
        return month;
    }

    public int getDay()
    {
        return day;
    }

    private static void validateYear(final int year)
    {
        if (year > CURRENT_YEAR)
        {
            throw new IllegalArgumentException("can't have future years");
        }
    }

    private static void validateMonth(final int month)
    {
        if (month < MIN_MONTH ||
            month > MAX_MONTH)
        {
            throw new IllegalArgumentException("invalid month");
        }
    }

    private static void validateDay(final int day)
    {
        if (day < MIN_DAY ||
            day > MAX_DAY)
        {
            throw new IllegalArgumentException("invalid day");
        }
    }

    public static int getCurrentYear()
    {
        return CURRENT_YEAR;
    }

    public String toString()
    {
        return year + "-" + month + "-" + day;
    }
}
