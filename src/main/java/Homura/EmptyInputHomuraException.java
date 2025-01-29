// How to use and create packages inspired by
// https://github.com/weiseng18/ip/tree/master/src/main/java/panorama
// and
// https://www.w3schools.com/java/java_packages.asp
package Homura;

public class EmptyInputHomuraException extends HomuraRuntimeException {
    public static final String indent = "    ";

    private String cmd;
    private String inp;

    public EmptyInputHomuraException() {
        super();
    }
    public EmptyInputHomuraException(String cmd, String inp) {
        super();
        this.cmd = cmd;
        this.inp = inp;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName()
            + " - Empty input passed to cmd " + cmd + ":" + '\n'
            + indent + indent + inp;
    }
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
