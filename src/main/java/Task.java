public class Task {
    public String description;
    public boolean is_done;

    public Task(String descr) {
        description = descr;
        is_done = false;
    }

    @Override
    public String toString() {
        if (is_done) {
            return "[✓] " + description;
        } else {
            return "[ ] " + description;
        }
    }
}
