package ca.bcit.comp2522.lab2;

public class Dragon extends Creature
{
    private int firePower;

    private final static int MIN_FIRE_POWER = 0;
    private final static int REQUIRED_MIN_FIRE_POWER = 10;
    private final static int MAX_FIRE_POWER = 100;

    public Dragon(final String name,
           final Date dateOfBirth,
           final int health,
           final int firePower)
    {
        super(name,
                dateOfBirth,
                health);
        this.firePower = validateFirePower(firePower);
    }

    private int validateFirePower(final int firePower)
    {
        if (firePower < MIN_FIRE_POWER ||
            firePower > MAX_FIRE_POWER)
        {
            throw new IllegalArgumentException("invalid firepower");
        }
        return firePower;
    }

    public void breatheFire(Creature target) throws LowFirePowerException
    {
        if (firePower < REQUIRED_MIN_FIRE_POWER)
        {
            throw new LowFirePowerException("not enough firepower, you need " +
                    REQUIRED_MIN_FIRE_POWER);
        }

        firePower -= 10;
        target.takeDamage(20);
    }

    public void restoreFirePower(final int amount)
    {
        firePower += amount;

        if (firePower > MAX_FIRE_POWER)
        {
            firePower = MAX_FIRE_POWER;
        }
    }


    @Override
    public String getDetails()
    {
        return super.getDetails() + ", FirePower: " + firePower;
    }
}

