public class TODO {
    public static final String indent = Homura.indent;
    public static final String divider = Homura.divider;

    public String description;
    public boolean is_done;

    public TODO(String descr) {
        description = descr;
        is_done = false;
    }

    public static TODO parse(String inp) {
        try {
            inp = inp.substring(5);   // Remove the "todo " in front
            return new TODO(inp);
        } catch (Exception e) {
            throw new InvalidInputException("TODO", inp);
        }
    }

    @Override
    public String toString() {
        if (is_done) {
            return "[T][✓] " + description;
        } else {
            return "[T][ ] " + description;
        }
    }

    public String add_str() {
        // Getting class name as a string inspired by
        // https://stackoverflow.com/questions/6271417/java-get-the-current-class-name
        return indent + divider + '\n'
            + indent + " " + this.getClass().getSimpleName() + " added" + '\n'
            + indent + " " + this.toString() + '\n'
            + indent + divider;
    }

    public String mark_str() {
        return indent + divider + '\n'
            + indent + " " + this.getClass().getSimpleName() + " marked as done" + '\n'
            + indent + " " + this.toString() + '\n'
            + indent + divider;
    }

    public String unmark_str() {
        return indent + divider + '\n'
            + indent + " " + this.getClass().getSimpleName() + " marked as not done" + '\n'
            + indent + " " + this.toString() + '\n'
            + indent + divider;
    }
}
