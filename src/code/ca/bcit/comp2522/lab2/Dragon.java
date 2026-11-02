package ca.bcit.comp2522.lab2;

/**
 * Represents a creature that can breathe fire.
 */
public class Dragon extends Creature
{
    private static final int MIN_FIRE_POWER;
    private static final int REQUIRED_MIN_FIRE_POWER;
    private static final int MAX_FIRE_POWER;
    private static final int FIRE_POWER_COST;
    private static final int FIRE_DAMAGE;

    private int firePower;

    static
    {
        MIN_FIRE_POWER          = 0;
        REQUIRED_MIN_FIRE_POWER = 10;
        MAX_FIRE_POWER          = 100;
        FIRE_POWER_COST         = 10;
        FIRE_DAMAGE             = 20;
    }

    /**
     * Constructs a dragon with validated creature details and fire power.
     *
     * @param name        the dragon's name
     * @param dateOfBirth the dragon's date of birth
     * @param health      the dragon's starting health
     * @param firePower   the dragon's starting fire power
     * @throws IllegalArgumentException if any value is invalid
     */
    public Dragon(final String name,
                  final Date   dateOfBirth,
                  final int    health,
                  final int    firePower)
    {
        super(name,
                dateOfBirth,
                health);
        validateFirePower(firePower);
        this.firePower = firePower;
    }

    /**
     * Validates the dragon's fire power.
     *
     * @param firePower the fire power to validate
     * @throws IllegalArgumentException if fire power is outside its valid range
     */
    private static void validateFirePower(final int firePower)
    {
        if (firePower < MIN_FIRE_POWER || firePower > MAX_FIRE_POWER)
        {
            throw new IllegalArgumentException("invalid firepower");
        }
    }

    /**
     * Uses fire power to damage a target creature.
     *
     * @param target the creature to damage
     * @throws LowFirePowerException if fire power is below the required amount
     */
    public void breatheFire(final Creature target) throws LowFirePowerException
    {
        if (firePower < REQUIRED_MIN_FIRE_POWER)
        {
            throw new LowFirePowerException("not enough firepower, you need " +
                    REQUIRED_MIN_FIRE_POWER);
        }

        firePower -= FIRE_POWER_COST;
        target.takeDamage(FIRE_DAMAGE);
    }

    /**
     * Restores fire power up to the maximum.
     *
     * @param amount the amount of fire power to restore
     */
    public void restoreFirePower(final int amount)
    {
        firePower += amount;

        if (firePower > MAX_FIRE_POWER)
        {
            firePower = MAX_FIRE_POWER;
        }
    }

    /**
     * Returns the creature's details and fire power.
     *
     * @return the dragon's details
     */
    @Override
    public String getDetails()
    {
        return super.getDetails() + ", FirePower: " + firePower;
    }
}
