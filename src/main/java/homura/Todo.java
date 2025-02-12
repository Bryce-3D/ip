package homura;

import java.util.ArrayList;

/**
 * A class representing a Todo item.
 */
public class Todo {
    // Attributes + Getters and Setters ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    private String description;
    private boolean isDone;

    public String getDescription() {
        return description;
    }
    public void setDescription(String des) {
        description = des;
    }
    public boolean getIsDone() {
        return isDone;
    }
    public void setIsDone(boolean b) {
        isDone = b;
    }



    // Constructors and Factory Methods ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public Todo(String descr) {
        description = descr;
        isDone = false;
    }



    // String Methods ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    /**
     * Returns a string representation of the object.
     *
     * @return A string representation of the object.
     */
    @Override
    public String toString() {
        if (isDone) {
            return "[T][✓] " + description;
        } else {
            return "[T][ ] " + description;
        }
    }
    /**
     * Converts a storage string to the object.
     *
     * @param s The storage string.
     * @return The object derived from the storage string.
     */
    public static Todo fromStorageStr(String s) {
        assert s.startsWith("t");
        ArrayList<String> ss = HomuraUtils.split(s, Storage.DIVIDER);
        Todo ans = new Todo(ss.get(2));
        if (ss.get(1).equals("1")) {
            ans.setIsDone(true);
        }
        return ans;
    }
    /**
     * Returns a string representation of the object for storage.
     *
     * @return A string representation of the object for storage.
     */
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



    // Edit Functions ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    /**
     * Edits the corresponding attribute.
     *
     * @param attr The attribute to edit.
     * @param newVal The new value for the attribute.
     */
    public void edit(String attr, String newVal) {
        switch (attr) {
        case "des":
            description = newVal;
            return;
        default:
            throw new HomuraRuntimeException();
        }
    }



    // Etc ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    /**
     * Compares if the object is the same as this.
     *
     * @param o The object being compared to.
     * @return Whether the objects are equal or not.
     */
    @Override
    public boolean equals(Object o) {
        // Non-null Todo
        if (o == null) {
            return false;
        }
        if (!(o instanceof Todo)) {
            return false;
        }
        Todo t = (Todo) o;

        // Compare attributes
        if (!description.equals(t.description)) {
            return false;
        }
        if (!isDone == t.isDone) {
            return false;
        }
        return true;
    }
    /**
     * Checks if s is in the description of the todo.
     *
     * @param s The string to lookup.
     * @return Whether s is in the description or not.
     */
    public boolean contains(String s) {
        s = s.toLowerCase();
        return description.contains(s);
    }
}
