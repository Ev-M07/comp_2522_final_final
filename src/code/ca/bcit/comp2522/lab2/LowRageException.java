package ca.bcit.comp2522.lab2;

/**
 * Represents an error caused by invalid rage.
 */
public class LowRageException extends RuntimeException
{
    /**
     * Constructs a low rage exception with a message.
     *
     * @param message the exception message
     */
    public LowRageException(final String message)
    {
        super(message);
    }
}
