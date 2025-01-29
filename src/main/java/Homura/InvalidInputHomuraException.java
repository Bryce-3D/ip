/**
 * An exception for when a command receives an invalid input.
 */

// How to use and create packages inspired by
// https://github.com/weiseng18/ip/tree/master/src/main/java/panorama
// and
// https://www.w3schools.com/java/java_packages.asp
package Homura;

public class InvalidInputHomuraException extends HomuraRuntimeException {
    public static final String indent = "    ";

    public String cmd;
    public String inp;

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
