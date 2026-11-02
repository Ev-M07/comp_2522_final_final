package ca.bcit.comp2522.lab2;

/**
 * Represents an error caused by insufficient mana.
 */
public class LowManaException extends Exception
{
    /**
     * Constructs a low mana exception with a message.
     *
     * @param message the exception message
     */
    public LowManaException(final String message)
    {
        super(message);
    }
}
