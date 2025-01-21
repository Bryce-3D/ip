public class EmptyInputHomuraException extends HomuraRuntimeException {
    public static final String indent = "    ";

    public String cmd;
    public String inp;

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
}
