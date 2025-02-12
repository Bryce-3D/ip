package homura;

/**
 * An exception for any runtime exceptions relating to Homura.
 */
public class HomuraRuntimeException extends RuntimeException {
    /**
     * Creates a blank HomuraRuntimeException.
     */
    public HomuraRuntimeException() {
        super();
    }

    /**
     * Creates a default HomuraRuntimeException.
     *
     * @param message The message in the exception.
     */
    public HomuraRuntimeException(String message) {
        super(message);
    }
}
