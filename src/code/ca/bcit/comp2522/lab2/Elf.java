package ca.bcit.comp2522.lab2;

/**
 * Represents a creature that can cast spells using mana.
 */
public class Elf extends Creature
{
    private static final int MIN_MANA;
    private static final int REQUIRED_MIN_MANA;
    private static final int MAX_MANA;
    private static final int SPELL_DAMAGE;

    private int mana;

    static
    {
        MIN_MANA          = 0;
        REQUIRED_MIN_MANA = 5;
        MAX_MANA          = 50;
        SPELL_DAMAGE      = 10;
    }

    /**
     * Constructs an elf with validated creature details and mana.
     *
     * @param name        the elf's name
     * @param dateOfBirth the elf's date of birth
     * @param health      the elf's starting health
     * @param mana        the elf's starting mana
     * @throws IllegalArgumentException if any value is invalid
     */
    public Elf(final String name,
               final Date   dateOfBirth,
               final int    health,
               final int    mana)
    {
        super(name, dateOfBirth, health);
        validateMana(mana);
        this.mana = mana;
    }

    /**
     * Validates the elf's mana.
     *
     * @param mana the mana to validate
     * 
     * @throws IllegalArgumentException if mana is outside its valid range
     */
    private static void validateMana(final int mana)
    {
        if (mana < MIN_MANA ||
                mana > MAX_MANA)
        {
            throw new IllegalArgumentException("invalid mana");
        }
    }

    /**
     * Casts a spell that damages a target creature.
     *
     * @param target the creature to damage
     * 
     * @throws LowManaException if mana is below the required amount
     */
    public void castSpell(final Creature target) throws LowManaException
    {
        if (mana < REQUIRED_MIN_MANA)
        {
            throw new LowManaException("Not enough mana, you need at least " +
                    REQUIRED_MIN_MANA);
        }

        mana -= REQUIRED_MIN_MANA;
        target.takeDamage(SPELL_DAMAGE);
    }

    /**
     * Restores mana up to the maximum.
     *
     * @param amount the amount of mana to restore
     */
    public void restoreMana(final int amount)
    {
        mana += amount;

        if (mana > MAX_MANA)
        {
            mana = MAX_MANA;
        }
    }

    /**
     * Returns the creature's details and mana.
     *
     * @return the elf's details
     */
    @Override
    public String getDetails()
    {
        return super.getDetails() +
                ", Mana: "        +
                mana;
    }
}
