import java.util.ArrayList;

public class Todo {
    // Attributes + Getters and Setters ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    private static final String INDENT = Homura.INDENT;
    private static final String DIVIDER = Homura.DIVIDER;
    private String description;
    private boolean isDone;

    public String getDescription() { return description; }
    public boolean getIsDone() { return isDone; }
    public void setIsDone(boolean b) { isDone = b; }



    // Constructors and Factory Methods ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public Todo(String descr) {
        description = descr;
        isDone = false;
    }



    // String Methods ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    @Override
    public String toString() {
        if (isDone) {
            return "[T][✓] " + description;
        } else {
            return "[T][ ] " + description;
        }
    }
    public static Todo fromStorageStr(String s) {
        ArrayList<String> ss = HomuraUtils.split(s, Storage.DIVIDER);
        Todo ans = new Todo(ss.get(2));
        if (ss.get(1).equals("1")) {
            ans.setIsDone(true);
        }
        return ans;
    }
    public String toStorageStr() {
        // t | 0 or 1 | descr
        String ans = "t" + Storage.DIVIDER;
        if (isDone) {
            ans += 1;
        } else {
            ans += 0;
        }
        ans += Storage.DIVIDER + description;
        return ans;
    }



    // Special String Methods ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // !TODO! Either remove these or fix it
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





// Recycling Bin ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
/*
    public static Todo parseUserInp(String inp) {
        inp = inp.strip();
        if (inp.length() <= 5) {
            throw new EmptyInputHomuraException("Todo", inp);
        }
        inp = inp.substring(5);   // Remove the "todo " in front
        return new Todo(inp);
    }
 */



    /**
     * Converts a storage string representation to a Todo.
     *
     * @param s The storage string.
     * @return The Todo.
     */

    /**
     * Converts to a String representation for storage.
     * The current format is `t | 0 or 1 | descr`.
     *
     * @return The storage representation.
     */

