package ca.bcit.comp2522.lab2;

/**
 * Represents a date containing a year, month, and day.
 */
public class Date
{
    private static final int CURRENT_YEAR;
    private static final int MAX_MONTH;
    private static final int MIN_MONTH;
    private static final int MIN_DAY;
    private static final int MAX_DAY;

    private final int year;
    private final int month;
    private final int day;

    static
    {
        CURRENT_YEAR = 2026;
        MAX_MONTH    = 12;
        MIN_MONTH    = 1;
        MIN_DAY      = 1;
        MAX_DAY      = 31;
    }

    /**
     * Constructs a {@code Date}, validating that the year, month, and day are
     * within their supported ranges.
     *
     * @param year  the year
     * @param month the month
     * @param day   the day
     * @throws IllegalArgumentException if any value is outside its valid range
     */
    Date(final int year,
         final int month,
         final int day)
    {
        validateYear(year);
        validateMonth(month);
        validateDay(day);

        this.year = year;
        this.month = month;
        this.day = day;
    }

    /**
     * Returns the year.
     *
     * @return the year
     */
    public int getYear()
    {
        return year;
    }

    /**
     * Returns the month.
     *
     * @return the month
     */
    public int getMonth()
    {
        return month;
    }

    /**
     * Returns the day.
     *
     * @return the day
     */
    public int getDay()
    {
        return day;
    }

    /**
     * Validates that a year is not in the future.
     *
     * @param year the year to validate
     * @throws IllegalArgumentException if {@code year} is after the current year
     */
    private static void validateYear(final int year)
    {
        if (year > CURRENT_YEAR)
        {
            throw new IllegalArgumentException("can't have future years");
        }
    }

    /**
     * Validates that a month is within the calendar range.
     *
     * @param month the month to validate
     * @throws IllegalArgumentException if {@code month} is outside 1 through 12
     */
    private static void validateMonth(final int month)
    {
        if (month < MIN_MONTH ||
                month > MAX_MONTH)
        {
            throw new IllegalArgumentException("invalid month");
        }
    }

    /**
     * Validates that a day is within the supported range.
     *
     * @param day the day to validate
     * @throws IllegalArgumentException if {@code day} is outside 1 through 31
     */
    private static void validateDay(final int day)
    {
        if (day < MIN_DAY ||
                day > MAX_DAY)
        {
            throw new IllegalArgumentException("invalid day");
        }
    }

    /**
     * Returns the current year used to validate dates.
     *
     * @return the current year
     */
    public static int getCurrentYear()
    {
        return CURRENT_YEAR;
    }

    /**
     * Returns the date in year-month-day format.
     *
     * @return the formatted date
     */
    @Override
    public String toString()
    {
        return year   +
                "-"   +
                month +
                "-"   +
                day;
    }
}
