package ca.bcit.comp2522.lab2;

/**
 * Represents an error caused by insufficient fire power.
 */
public class LowFirePowerException extends Exception
{
    /**
     * Constructs a low fire power exception with a message.
     *
     * @param message the exception message
     */
    public LowFirePowerException(final String message)
    {
        super(message);
    }
}
