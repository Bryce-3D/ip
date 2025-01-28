// How to use and create packages inspired by
// https://github.com/weiseng18/ip/tree/master/src/main/java/panorama
// and
// https://www.w3schools.com/java/java_packages.asp
package Homura;

public class HomuraRuntimeException extends RuntimeException {
    public HomuraRuntimeException() {
        super();
    }
    public HomuraRuntimeException(String message) {
        super(message);
    }
}
