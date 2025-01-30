/**
 * An exception for when an invalid command is passed to Homura.
 */

// How to use and create packages inspired by
// https://github.com/weiseng18/ip/tree/master/src/main/java/panorama
// and
// https://www.w3schools.com/java/java_packages.asp
package homura;

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
