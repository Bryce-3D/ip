public class Todo {
    public static final String INDENT = Homura.INDENT;
    public static final String divider = Homura.DIVIDER;

    public String description;
    public boolean isDone;

    public Todo(String descr) {
        description = descr;
        isDone = false;
    }

    public static Todo parse(String inp) {
        inp = inp.strip();
        if (inp.length() <= 5) {
            throw new EmptyInputHomuraException("Todo", inp);
        }
        inp = inp.substring(5);   // Remove the "todo " in front
        return new Todo(inp);
    }

    @Override
    public String toString() {
        if (isDone) {
            return "[T][✓] " + description;
        } else {
            return "[T][ ] " + description;
        }
    }

    public String addStr() {
        // Getting class name as a string inspired by
        // https://stackoverflow.com/questions/6271417/java-get-the-current-class-name
        return INDENT + divider + '\n'
            + INDENT + " " + getClass().getSimpleName() + " added" + '\n'
            + INDENT + " " + this + '\n'
            + INDENT + divider;
    }

    public String markStr() {
        return INDENT + divider + '\n'
            + INDENT + " " + getClass().getSimpleName() + " marked as done" + '\n'
            + INDENT + " " + this + '\n'
            + INDENT + divider;
    }

    public String unmarkStr() {
        return INDENT + divider + '\n'
            + INDENT + " " + this.getClass().getSimpleName() + " marked as not done" + '\n'
            + INDENT + " " + this.toString() + '\n'
            + INDENT + divider;
    }
}
