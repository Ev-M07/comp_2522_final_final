package ca.bcit.comp2522.lab2;

/**
 * Represents a creature with a name, date of birth, and health.
 */
public class Creature
{
    private static final int MIN_HEALTH;
    private static final int MAX_HEALTH;
    private static final int MIN_DAMAGE;

    private final String name;
    private final Date   dateOfBirth;

    private int health;

    static
    {
        MIN_HEALTH  = 1;
        MAX_HEALTH  = 100;
        MIN_DAMAGE  = 0;
    }

    /**
     * Constructs a creature with validated details.
     *
     * @param name        the creature's name
     * @param dateOfBirth the creature's date of birth
     * @param health      the creature's starting health
     * @throws IllegalArgumentException if the name, date of birth, or health is invalid
     */
    public Creature(final String name,
                    final Date   dateOfBirth,
                    final int    health)
    {
        validateName(name);
        validateDateOfBirth(dateOfBirth);
        validateHealth(health);

        this.name        = name;
        this.dateOfBirth = dateOfBirth;
        this.health      = health;
    }

    /**
     * Validates the creature's name.
     *
     * @param name the name to validate
     * 
     * @throws IllegalArgumentException if the name is null or empty
     */
    private static void validateName(final String name)
    {
        if (name == null || 
            name.isEmpty())
        {
            throw new IllegalArgumentException("name can't be null or empty");
        }
    }

    /**
     * Validates that the creature's date of birth is not in the future.
     *
     * @param dateOfBirth the date of birth to validate
     * 
     * @throws IllegalArgumentException if the date of birth is in the future
     */
    private static void validateDateOfBirth(final Date dateOfBirth)
    {
        if (dateOfBirth.getYear() > Date.getCurrentYear())
        {
            throw new IllegalArgumentException("date of birth cant be in the future");
        }
    }

    /**
     * Validates the creature's health.
     *
     * @param health the health to validate
     * 
     * @throws IllegalArgumentException if health is outside 1 through 100
     */
    private static void validateHealth(final int health)
    {
        if (health < MIN_HEALTH || 
            health > MAX_HEALTH)
        {
            throw new IllegalArgumentException("Health must be between 1 and 100");
        }
    }

    /**
     * Returns the creature's date of birth.
     *
     * @return the creature's date of birth
     */
    private Date getDateOfBirth()
    {
        return dateOfBirth;
    }

    /**
     * Determines whether the creature is alive.
     *
     * @return true if health is above zero
     */
    private boolean isAlive()
    {
        return health > MIN_HEALTH;
    }

    /**
     * Reduces this creature's health by the given amount.
     *
     * @param damage the amount of damage to take
     * 
     * @throws DamageException if damage is negative
     */
    public void takeDamage(final int damage)
    {
        if (damage < MIN_DAMAGE)
        {
            throw new DamageException("Damage cannot be negative");
        }

        health -= damage;

        if (health < MIN_HEALTH)
        {
            health = MIN_HEALTH;
        }
    }

    /**
     * Restores health up to the maximum.
     *
     * @param healAmount the amount of health to restore
     * 
     * @throws HealingException if the creature's health is below zero
     */
    public void heal(final int healAmount)
    {
        if (health < MIN_HEALTH)
        {
            throw new HealingException("healing cant be negative");
        }
        health += healAmount;

        if (health > MAX_HEALTH)
        {
            health = MAX_HEALTH;
        }
    }

    /**
     * Returns the creature's age in years.
     *
     * @return the creature's age
     */
    public int getAgeYears()
    {
        return Date.getCurrentYear() - dateOfBirth.getYear();
    }

    /**
     * Returns the creature's details.
     * 
     * USE STRING BUUILDER TO CONCATENATE STRINGS INSTEAD OF USING + OPERATOR
     *
     * @return the creature's name, date of birth, age, and health
     */
    public String getDetails()
    {
        return "Name: "       +
                name          +
                ", DOB: "     +
                dateOfBirth   +
                ", Age: "     +
                getAgeYears() +
                ", Health: "  +
                health;
    }
}
