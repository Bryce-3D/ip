// How to use and create packages inspired by
// https://github.com/weiseng18/ip/tree/master/src/main/java/panorama
// and
// https://www.w3schools.com/java/java_packages.asp
package Homura;

public class InvalidCmdHomuraException extends HomuraRuntimeException {
    public static final String indent = "    ";

    private String cmd;

    public InvalidCmdHomuraException() {
        super();
    }
    public InvalidCmdHomuraException(String cmd) {
        super();
        this.cmd = cmd;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName()
            + " - Invalid cmd passed: " + cmd;
    }
}
