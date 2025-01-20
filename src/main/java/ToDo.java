public class ToDo {
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
}
