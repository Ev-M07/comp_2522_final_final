package ca.bcit.comp2522.lab2;

/**
 * Represents an error caused by invalid healing.
 */
public class HealingException extends RuntimeException
{
    /**
     * Constructs a healing exception with a message.
     *
     * @param message the exception message
     */
    public HealingException(final String message)
    {
        super(message);
    }
}
