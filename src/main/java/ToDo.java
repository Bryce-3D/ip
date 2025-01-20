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

    public String add_str() {
        return indent + divider + '\n'
            + indent + " TODO added" + '\n'
            + indent + " " + this.toString() + '\n'
            + indent + divider + '\n';
    }

    public String mark_str() {
        return indent + divider + '\n'
            + indent + " TODO marked as done" + '\n'
            + indent + " " + this.toString() + '\n'
            + indent + divider + '\n';
    }

    public String unmark_str() {
        return indent + divider + '\n'
            + indent + "TODO marked as not done" + '\n'
            + indent + " " + this.toString() + '\n'
            + indent + divider + '\n';
    }
}
