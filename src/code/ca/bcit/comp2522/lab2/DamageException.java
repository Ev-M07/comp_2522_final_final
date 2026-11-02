package ca.bcit.comp2522.lab2;

/**
 * Represents an error caused by invalid damage.
 */
public class DamageException extends RuntimeException
{
    /**
     * Constructs a damage exception with a message.
     *
     * @param message the exception message
     */
    public DamageException(final String message)
    {
        super(message);
    }
}
