public class InvalidCmdHomuraException extends HomuraRuntimeException {
    public static final String indent = "    ";

    public String cmd;

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
