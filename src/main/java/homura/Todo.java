/**
 * A class representing a Todo item.
 */

// How to use and create packages inspired by
// https://github.com/weiseng18/ip/tree/master/src/main/java/panorama
// and
// https://www.w3schools.com/java/java_packages.asp
package homura;

import java.util.ArrayList;

public class Todo {
    // Attributes + Getters and Setters ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    private static final String INDENT = Homura.INDENT;
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



    // Special String Methods ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // !TODO! Either remove these or fix it
    /**
     * Generates a string to send when a Todo is created.
     *
     * @return The string to send when a Todo is created.
     */
    public String addStrJavafx() {
        return getClass().getSimpleName() + " added" + '\n'
                + INDENT + this + '\n';
    }
    /**
     * Generates a string to send when a Todo is marked.
     *
     * @return The string to send when a Todo is marked.
     */
    public String markStrJavafx() {
        return getClass().getSimpleName() + " marked as done" + '\n'
                + INDENT + this + '\n';
    }
    /**
     * Generates a string to send when a Todo is unmarked.
     *
     * @return The string to send when a Todo is unmarked.
     */
    public String unmarkStrJavafx() {
        return getClass().getSimpleName() + " marked as not done" + '\n'
                + INDENT + this + '\n';
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
        if (o == null) { return false; }
        if (!(o instanceof Todo)) { return false; }
        Todo t = (Todo) o;

        // Compare attributes
        if (!description.equals(t.description)) { return false; }
        if (!isDone == t.isDone) { return false; }
        return true;
    }
    /**
     * Checks if s is in the description of the todo.
     *
     * @param s The string to lookup.
     * @return Whether s is in the description or not.
     */
    public boolean contains(String s) {
        // How to check if a string is a substring of another string
        // inspired by ChatGPT with the query "Hi! How can I check if
        // a string `s0` is contained as a substring of another string
        // `s` in Java? Thanks!"
        s = s.toLowerCase();
        return description.contains(s);
    }
}





// Recycling Bin ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
