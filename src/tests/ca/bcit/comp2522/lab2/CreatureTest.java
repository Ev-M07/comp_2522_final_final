package ca.bcit.comp2522.lab2;

/**
 * Runs a basic demonstration of the creature classes.
 */
public class CreatureTest
{
    /**
     * Creates example creatures and exercises their behavior.
     *
     * @param args command-line arguments
     */
    public static void main(final String[] args)
    {
        try
        {
            final Dragon dragon;
            dragon = new Dragon("Dragon",
                    new Date(2000, 5, 10),
                    80,
                    50);

            final Elf elf;
            elf = new Elf("Elf",
                    new Date(2010, 3, 20),
                    70,
                    30);

            final Orc orc;
            orc = new Orc("Orc",
                    new Date(2010, 4, 23),
                    40,
                    20);

            System.out.println(dragon.getDetails());
            System.out.println(elf.getDetails());
            System.out.println(orc.getDetails());

            System.out.println(dragon instanceof Creature);
            System.out.println(dragon.getClass());

            System.out.println(elf instanceof Creature);
            System.out.println(elf.getClass());

            System.out.println(orc instanceof Creature);
            System.out.println(orc.getClass());

            dragon.breatheFire(elf);
            elf.castSpell(dragon);
            orc.berserk(dragon);
            dragon.breatheFire(orc);
        }
        catch (final DamageException e)
        {
            System.out.println("Damage error: " + e.getMessage());
        }
        catch (final HealingException e)
        {
            System.out.println("Healing error: " + e.getMessage());
        }
        catch (final LowManaException e)
        {
            System.out.println("Elf error: " + e.getMessage());
        }
        catch (final LowFirePowerException e)
        {
            System.out.println("Fire power error: " + e.getMessage());
        }
    }
}
