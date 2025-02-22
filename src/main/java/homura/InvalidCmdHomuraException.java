package homura;

/**
 * An exception for when an invalid command is passed to Homura.
 */
public class InvalidCmdHomuraException extends HomuraRuntimeException {
    public static final String indent = "    ";

    private String cmd;

    /**
     * Creates an InvalidCmdHomuraException.
     * 
     * @param cmd The invalid passed command.
     */
    public InvalidCmdHomuraException(String cmd) {
        super();
        this.cmd = cmd;
    }

    /**
     * Returns a string representation of the object.
     *
     * @return A string representation of the object.
     */
    @Override
    public String toString() {
        return getClass().getSimpleName()
            + " - Invalid cmd passed: " + cmd;
    }
}
