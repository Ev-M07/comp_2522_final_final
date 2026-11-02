package ca.bcit.comp2522.lab2;

/**
 * Represents a creature that can attack using rage.
 */
public class Orc extends Creature
{
    private static final int MIN_RAGE;
    private static final int DOUBLE_DAMAGE_RAGE;
    private static final int MAX_RAGE;
    private static final int RAGE_INCREASE;
    private static final int NORMAL_DAMAGE;
    private static final int DOUBLE_DAMAGE;

    private int rage;

    static
    {
        MIN_RAGE           = 0;
        DOUBLE_DAMAGE_RAGE = 20;
        MAX_RAGE           = 30;
        RAGE_INCREASE      = 5;
        NORMAL_DAMAGE      = 15;
        DOUBLE_DAMAGE      = 30;
    }

    /**
     * Constructs an orc with validated creature details and rage.
     *
     * @param name        the orc's name
     * @param dateOfBirth the orc's date of birth
     * @param health      the orc's starting health
     * @param rage        the orc's starting rage
     * @throws IllegalArgumentException if any value is invalid
     */
    public Orc(final String name,
               final Date   dateOfBirth,
               final int    health,
               final int    rage)
    {
        super(name, dateOfBirth, health);
        validateRage(rage);
        this.rage = rage;
    }

    /**
     * Validates the orc's rage.
     *
     * @param rage the rage to validate
     * 
     * @throws LowRageException if rage is outside its valid range
     */
    private static void validateRage(final int rage)
    {
        if (rage < MIN_RAGE || rage > MAX_RAGE)
        {
            throw new LowRageException("Mana must be between " + MIN_RAGE + " and" + MAX_RAGE);
        }
    }

    /**
     * Attacks a target creature, dealing more damage when rage is high.
     *
     * @param target the creature to attack
     */
    public void berserk(final Creature target)
    {
        rage += RAGE_INCREASE;

        if (rage > DOUBLE_DAMAGE_RAGE)
        {
            target.takeDamage(DOUBLE_DAMAGE);
        }
        else
        {
            target.takeDamage(NORMAL_DAMAGE);
        }
    }

    /**
     * Returns the creature's details and rage.
     *
     * @return the orc's details
     */
    @Override
    public String getDetails()
    {
        return super.getDetails() + ", rage" + rage;
    }
}
