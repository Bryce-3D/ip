public class ToDo {
    public static final String indent = Homura.indent;
    public static final String divider = Homura.divider;

    public String description;
    public boolean is_done;

    public ToDo(String descr) {
        description = descr;
        is_done = false;
    }

    @Override
    public String toString() {
        if (is_done) {
            return "[T][✓] " + description;
        } else {
            return "[T][ ] " + description;
        }
    }

    public String mark_str() {
        return indent + divider + '\n'
            + indent + " [T][] " + description + '\n'
            + indent + divider + '\n';
    }
}
