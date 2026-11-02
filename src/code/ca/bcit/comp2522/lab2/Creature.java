package ca.bcit.comp2522.lab2;

public class Creature
{
    private static final int ZERO_HEALTH = 0;
    private static final int MIN_HEALTH = 1;
    private static final int MAX_HEALTH  = 100;

    private final String name;
    private final Date dateOfBirth;

    private int health;

    public Creature(final String name,
                    final Date dateOfBirth,
                    final int health)
    {
        this.name        = validateName(name);
        this.dateOfBirth = validateDateOfBirth(dateOfBirth);
        this.health      = validateHealth(health);
    }

    private String validateName(final String name)
    {
        if (name == null || name.isEmpty())
        {
            throw new IllegalArgumentException("name can't be null or empty");
        }
        return name;
    }

    private Date validateDateOfBirth(final Date dateOfBirth)
    {
        if (dateOfBirth.getYear()> Date.getCurrentYear())
        {
            throw new IllegalArgumentException("date of birth cant be in the future");
        }
        return dateOfBirth;
    }

    private int validateHealth(final int health)
    {
        if (health < MIN_HEALTH ||
            health > MAX_HEALTH)
        {
            throw new IllegalArgumentException("Health must be between 1 and 100");
        }
        return health;
    }

    private Date getDateOfBirth()
    {
        return dateOfBirth;
    }

    private Boolean isAlive()
    {
        return health > ZERO_HEALTH;
    }

    public void takeDamage(final int damage)
    {
        if (damage < 0)
        {
            throw new DamageException("Damage cannot be negative");
        }

        health -= damage;

        if (health < ZERO_HEALTH)
        {
            health = ZERO_HEALTH;
        }
    }



    public void heal(final int healAmount)
    {
        if (health < ZERO_HEALTH)
        {
            throw new HealingException("healing cant be negative");
        }
        health += healAmount;

        if (health > MAX_HEALTH)
        {
            health = MAX_HEALTH;
        }
    }


    public int getAgeYears()
    {
        return Date.getCurrentYear() - dateOfBirth.getYear();
    }

    public String getDetails()
    {
        return "Name: " +
                name +
                ", DOB: " +
                dateOfBirth +
                ", Age: " +
                getAgeYears() +
                ", Health: " +
                health;
    }
}
