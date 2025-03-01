package homura;

/**
 * An exception for when a command that needs an argument receives none.
 */
public class EmptyInputHomuraException extends HomuraRuntimeException {
    public static final String INDENT = "    ";

    private String cmd;
    private String inp;

    /**
     * Creates an EmptyInputHomuraException.
     *
     * @param cmd The passed command.
     * @param inp The full input passed.
     */
    public EmptyInputHomuraException(String cmd, String inp) {
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
            + " - Empty input passed to cmd " + cmd + ":" + '\n'
            + INDENT + INDENT + inp;
    }

    /**
     * Compares with another object for equality.
     *
     * @param o The object being compared to.
     * @return Whether the objects are equal or not.
     */
    @Override
    public boolean equals(Object o) {
        // Non-null EmptyInputHomuraException
        if (o == null) {
            return false;
        }
        if (!(o instanceof EmptyInputHomuraException)) {
            return false;
        }
        EmptyInputHomuraException e = (EmptyInputHomuraException) o;

        // Compare attributes
        if (!cmd.equals(e.cmd)) {
            return false;
        }
        if (!inp.equals(e.inp)) {
            return false;
        }
        return true;
    }
}
