package ca.bcit.comp2522.lab2;

public class Orc extends Creature
{

    private int rage;

    private final static int MIN_RAGE = 0;
    private final static int DOUBLE_DAMAGE_RAGE = 20;
    private final static int MAX_RAGE = 30;

    public Orc(String name, Date dateOfBirth, int health, int rage)
    {
        super(name, dateOfBirth, health);
        this.rage = validateRage(rage);

    }

    private int validateRage(final int rage)
    {
        if (rage < MIN_RAGE ||
            rage > MAX_RAGE)
        {
            throw new LowRageException("Mana must be between " + MIN_RAGE + " and" + MAX_RAGE);
        }

        return rage;
    }

    public void berserk(Creature target)
    {
        rage += 5;

        if (rage > DOUBLE_DAMAGE_RAGE)
        {
            target.takeDamage(30);
        }
        else
        {
            target.takeDamage(15);
        }
    }

    @Override
    public String getDetails()
    {
        return super.getDetails() + ", rage" + rage;
    }
}
