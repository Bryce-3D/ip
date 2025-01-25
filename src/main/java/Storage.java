import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {
    public static final String DIVIDER = " | ";

    // Todo <-> Storage String conversions ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    /**
     * Convert a Todo to a String representation for storage.
     * The current format is `t | 0 or 1 | descr`
     *
     * @param t The Todo to store.
     * @return The storage representation of t.
     */
    public static String toStr(Todo t) {
        String ans = "t" + DIVIDER;
        if (t.getIsDone()) {
            ans += 1;
        } else {
            ans += 0;
        }
        ans += DIVIDER + t.getDescription();
        return ans;
    }
    /**
     * Convert a Deadline to a String representation for storage.
     * The current format is `d | 0 or 1 | descr | by`
     *
     * @param d The Deadline to store.
     * @return The storage representation of d.
     */
    public static String toStr(Deadline d) {
        String ans = "d" + DIVIDER;
        if (d.getIsDone()) {
            ans += 1;
        } else {
            ans += 0;
        }
        ans += DIVIDER + d.getDescription()
                + DIVIDER + d.getBy();
        return ans;
    }
    /**
     * Convert a Event to a String representation for storage.
     * The current format is `e | 0 or 1 | descr | sta | end`
     *
     * @param e The Event to store.
     * @return The storage representation of e.
     */
    public static String toStr(Event e) {
        // e | 0 or 1 | descr | sta | end
        String ans = "e" + DIVIDER;
        if (e.getIsDone()) {
            ans += 1;
        } else {
            ans += 0;
        }
        ans += DIVIDER + e.getDescription()
                + DIVIDER + e.getSta()
                + DIVIDER + e.getEnd();
        return ans;
    }

    /**
     * Convert a storage String to a Todo or one of its subclasses.
     *
     * @param s The storage String representation.
     * @return The corresponding Todo, Deadline, or Event.
     */
    public static Todo fromStr(String s) {
        ArrayList<String> ss = HomuraUtils.split(s, DIVIDER);
        Todo ans;
        switch (ss.get(0)) {
        case "t":
            ans = new Todo(ss.get(2));
            break;
        case "d":
            ans = new Deadline(ss.get(2),ss.get(3));
            break;
        case "e":
            ans = new Event(ss.get(2),ss.get(3),ss.get(4));
            break;
        default:
            return null;
        }
        if (ss.get(1).equals("1")) {
            ans.setIsDone(true);
        }
        return ans;
    }

    public static void store_todos(ArrayList<Todo> tasks, String fn) {
        ArrayList<String> txts = new ArrayList<String>();
        // for
    }
}
