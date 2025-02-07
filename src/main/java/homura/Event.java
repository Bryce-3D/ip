/**
 * A class representing an Event item.
 */

// How to use and create packages inspired by
// https://github.com/weiseng18/ip/tree/master/src/main/java/panorama
// and
// https://www.w3schools.com/java/java_packages.asp
package homura;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Event extends Todo {
    // Attributes + Getters and Setters ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // Todo.str  description
    // Todo.bool isDone
    private LocalDate sta;
    private LocalDate end;

    public static final DateTimeFormatter dtfParse
            = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public static final DateTimeFormatter dtfToString
            = DateTimeFormatter.ofPattern("MMM dd yyyy");
    public static final DateTimeFormatter dtfToStorage
            = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public LocalDate getSta() {
        return sta;
    }
    public LocalDate getEnd() {
        return end;
    }



    // Constructors and Factory Methods ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public Event(String description, LocalDate sta, LocalDate end) {
        super(description);
        this.sta = sta;
        this.end = end;
    }
    public Event(String description, String staStr, String endStr) {
        super(description);
        this.sta = LocalDate.parse(staStr, dtfParse);
        this.end = LocalDate.parse(endStr, dtfParse);
    }



    // String Methods ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    /**
     * Returns a string representation of the object.
     *
     * @return A string representation of the object.
     */
    @Override
    public String toString() {
        String ans = "[E]";
        if (getIsDone()) {
            ans += "[✓] ";
        } else {
            ans += "[ ] ";
        }
        ans += getDescription()
                + " (from: " + sta.format(dtfToString)
                + " to: " + end.format(dtfToString) + ")";
        return ans;
    }
    /**
     * Converts a storage string to the object.
     *
     * @param s The storage string.
     * @return The object derived from the storage string.
     */
    public static Event fromStorageStr(String s) {
        assert s.startsWith("e");
        ArrayList<String> ss = HomuraUtils.split(s, Storage.DIVIDER);
        Event ans = new Event(ss.get(2), ss.get(3), ss.get(4));
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
        // e | 0 or 1 | descr | sta | end
        String ans = "e" + Storage.DIVIDER;
        if (getIsDone()) {
            ans += 1;
        } else {
            ans += 0;
        }
        ans += Storage.DIVIDER + getDescription()
                + Storage.DIVIDER + sta.format(dtfToStorage)
                + Storage.DIVIDER + end.format(dtfToStorage);
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
        // Non-null Event
        if (o == null) {
            return false;
        }
        if (!(o instanceof Event)) {
            return false;
        }
        Event e = (Event) o;

        // Compare attributes
        if (!getDescription().equals(e.getDescription())) {
            return false;
        }
        if (!getIsDone() == e.getIsDone()) {
            return false;
        }
        if (!sta.equals(e.sta)) {
            return false;
        }
        if (!end.equals(e.end)) {
            return false;
        }
        return true;
    }
}





// Recycling Bin ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
