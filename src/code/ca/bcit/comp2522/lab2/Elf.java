package ca.bcit.comp2522.lab2;

public class Elf extends Creature
{
    private int mana;

    private static final int MIN_MANA = 0;
    private static final int REQUIRED_MIN_MANA = 5;
    private static final int MAX_MANA = 50;

    public Elf(final String name,
               final Date dateOfBirth,
               final int health,
               final int mana)
    {
        super(name, dateOfBirth, health);
        this.mana = validateMana(mana);
    }

    private int validateMana(final int mana)
    {
        if (mana < MIN_MANA || mana > MAX_MANA)
        {
            throw new IllegalArgumentException("invalid mana");
        }
        return mana;
    }

    public void castSpell(final Creature target) throws LowManaException
    {
        if (mana < REQUIRED_MIN_MANA)
        {
            throw new LowManaException("Not enough mana, you need at least " +
                    REQUIRED_MIN_MANA);
        }

        mana -= REQUIRED_MIN_MANA;   // reduce mana by 5
        target.takeDamage(10);       // deal 10 damage
    }

    public void restoreMana(final int amount)
    {
        mana += amount;

        if (mana > MAX_MANA)
        {
            mana = MAX_MANA;
        }
    }

    @Override
    public String getDetails()
    {
        return super.getDetails() + ", Mana: " + mana;
    }
}
