public class Todo {
    private static final String INDENT = Homura.INDENT;
    private static final String DIVIDER = Homura.DIVIDER;

    private String description;
    private boolean isDone;

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

    public String getDescription() { return description; }
    public boolean getIsDone() { return isDone; }
    public void setIsDone(boolean b) { isDone = b; }

    @Override
    public String toString() {
        if (isDone) {
            return "[T][✓] " + description;
        } else {
            return "[T][ ] " + description;
        }
    }
    
    /**
     * Convert to a String representation for storage.
     * The current format is `t | 0 or 1 | descr`.
     *
     * @return The storage representation.
     */
    public String toStorageStr() {
        String ans = "t" + Storage.DIVIDER;
        if (isDone) {
            ans += 1;
        } else {
            ans += 0;
        }
        ans += Storage.DIVIDER + description;
        return ans;
    }

    public String addStr() {
        // Getting class name as a string inspired by
        // https://stackoverflow.com/questions/6271417/java-get-the-current-class-name
        return INDENT + DIVIDER + '\n'
                + INDENT + " " + getClass().getSimpleName() + " added" + '\n'
                + INDENT + " " + this + '\n'
                + INDENT + DIVIDER;
    }

    public String markStr() {
        return INDENT + DIVIDER + '\n'
                + INDENT + " " + getClass().getSimpleName() + " marked as done" + '\n'
                + INDENT + " " + this + '\n'
                + INDENT + DIVIDER;
    }

    public String unmarkStr() {
        return INDENT + DIVIDER + '\n'
                + INDENT + " " + this.getClass().getSimpleName() + " marked as not done" + '\n'
                + INDENT + " " + this.toString() + '\n'
                + INDENT + DIVIDER;
    }
}
