/**
 * A class representing a Deadline item.
 */

// How to use and create packages inspired by
// https://github.com/weiseng18/ip/tree/master/src/main/java/panorama
// and
// https://www.w3schools.com/java/java_packages.asp
package Homura;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Deadline extends Todo {
    // Attributes + Getters and Setters ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // Todo.str  description
    // Todo.bool isDone
    private LocalDate by;

    // Inspired by ChatGPT using queries "Hi! Can I have some
    // examples on how I can use LocalDate.Format() to format
    // my dates in Java?" and "Hi! Can I have some samples of
    // how LocalDate in Java can parse a string and return a
    // LocalDate object?"
    public static final DateTimeFormatter dtfParse
            = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public static final DateTimeFormatter dtfToString
            = DateTimeFormatter.ofPattern("MMM dd yyyy");
    public static final DateTimeFormatter dtfToStorage
            = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public LocalDate getBy() {
        return by;
    }


    // Constructors and Factory Methods ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public Deadline(String description, LocalDate by) {
        super(description);
        this.by = by;
    }
    public Deadline(String description, String byStr) {
        super(description);
        by = LocalDate.parse(byStr, dtfParse);
    }


    // String Methods ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    /**
     * Returns a string representation of the object.
     *
     * @return A string representation of the object.
     */
    @Override
    public String toString() {
        String ans = "[D]";
        if (getIsDone()) {
            ans += "[✓] ";
        } else {
            ans += "[ ] ";
        }
        ans += getDescription() + " (by: "
                + by.format(dtfToString) + ")";
        return ans;
    }
    /**
     * Converts a storage string to the object.
     *
     * @param s The storage string.
     * @return The object derived from the storage string.
     */
    public static Deadline fromStorageStr(String s) {
        ArrayList<String> ss = HomuraUtils.split(s, Storage.DIVIDER);
        Deadline ans = new Deadline(ss.get(2), ss.get(3));
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
    @Override
    public String toStorageStr() {
        // d | 0 or 1 | descr | by
        String ans = "d" + Storage.DIVIDER;
        if (getIsDone()) {
            ans += 1;
        } else {
            ans += 0;
        }
        ans += Storage.DIVIDER + getDescription()
                + Storage.DIVIDER + by.format(dtfToStorage);
        return ans;
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
        // Non-null Deadline
        if (o == null) { return false; }
        if (!(o instanceof Deadline)) { return false; }
        Deadline d = (Deadline) o;

        // Compare attributes
        if (!getDescription().equals(d.getDescription())) {
            return false;
        }
        if (!getIsDone() == d.getIsDone()) { return false; }
        if (!by.equals(d.by)) { return false; }
        return true;
    }
}





// Recycling Bin ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
/*
    public static Deadline parseUserInp(String inp) {
        inp = inp.strip();
        if (inp.length() <= 9) {
            throw new EmptyInputHomuraException("Todo", inp);
        }
        try {
            inp = inp.substring(9);   // Remove the "deadline " in front
            String[] splitInps = inp.split(" /by ");
            String descr = splitInps[0];
            String byStr = splitInps[1];
            return new Deadline(descr,byStr);
        } catch (Exception e) {
            throw new InvalidInputHomuraException("deadline", inp);
        }
    }
 */



    /**
     * Converts a storage string representation to a Deadline.
     *
     * @param s The storage string.
     * @return The Deadline.
     */

    /**
     * Converts to a String representation for storage.
     * The current format is `d | 0 or 1 | descr | by`.
     *
     * @return The storage representation.
     */



// TODO
    /*
    - Implement a fromStorageStr() function
    - Replicate similar updates to Event.java
    - Also implement fromStorageStr() in Todo.java
    - Update how Storage.readTodos() words (likely deprecating
      Storage.fromStr() in the process)
     */

/*
    @Override
    public String mark_str() {
        return indent + divider + '\n'
            + indent + " Deadline marked as done" + '\n'
            + indent + " " + this.toString() + '\n'
            + indent + divider + '\n';
    }
 */
/*
    @Override
    public String unmark_str() {
        return indent + divider + '\n'
            + indent + "Deadline marked as not done" + '\n'
            + indent + " " + this.toString() + '\n'
            + indent + divider + '\n';
    }
 */
