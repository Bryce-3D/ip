/**
 * An exception for when a command that needs an argument receives none.
 */

// How to use and create packages inspired by
// https://github.com/weiseng18/ip/tree/master/src/main/java/panorama
// and
// https://www.w3schools.com/java/java_packages.asp
package Homura;

public class EmptyInputHomuraException extends HomuraRuntimeException {
    public static final String indent = "    ";

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
            + indent + indent + inp;
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
        if (o == null) { return false; }
        if (!(o instanceof EmptyInputHomuraException)) { return false; }
        EmptyInputHomuraException e = (EmptyInputHomuraException) o;

        // Compare attributes
        if (!cmd.equals(e.cmd)) { return false; }
        if (!inp.equals(e.inp)) { return false; }
        return true;
    }
}
