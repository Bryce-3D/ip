package homura;

/**
 * An exception for when a command receives an invalid input.
 */
public class InvalidInputHomuraException extends HomuraRuntimeException {
    public static final String indent = "    ";

    private String cmd;
    private String inp;

    /**
     * Creates an InvalidInputHomuraException.
     *
     * @param cmd The passed command.
     * @param inp The full passed input.
     */
    public InvalidInputHomuraException(String cmd, String inp) {
        super();
        this.cmd = cmd;
        this.inp = inp;
    }

    /**
     * Returns a string representation of the object.
     *
     * @return A string representation of the object.
     */
    @Override
    public String toString() {
        return getClass().getSimpleName()
            + " - Invalid input passed to cmd " + cmd + ":" + '\n'
            + indent + indent + inp;
    }
}
