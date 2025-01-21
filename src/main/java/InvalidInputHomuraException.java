public class InvalidInputHomuraException extends HomuraRuntimeException {
    public static final String indent = "    ";

    public String cmd;
    public String invalid_input;

    public InvalidInputHomuraException(String cmd, String invalid_input) {
        super();
        this.cmd = cmd;
        this.invalid_input = invalid_input;
    }

    @Override
    public String toString() {
        return "java.lang.InvalidInputException: Invalid input passed to cmd " + cmd + ":" + '\n'
            + indent + indent + invalid_input;
    }
}
