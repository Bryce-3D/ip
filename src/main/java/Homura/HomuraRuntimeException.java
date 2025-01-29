/**
 * An exception for any runtime exceptions relating to Homura.
 */

// How to use and create packages inspired by
// https://github.com/weiseng18/ip/tree/master/src/main/java/panorama
// and
// https://www.w3schools.com/java/java_packages.asp
package Homura;

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
