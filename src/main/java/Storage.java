import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {
    public static final String DIVIDER = "|||";
    
    // Todo <-> Storage String conversions ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    /**
     * Convert a Todo to a String representation for storage.
     * The current format is `t | 0 or 1 | descr`
     *
     * @param t The Todo to store.
     * @return The storage representation of t.
     */
    public static String to_str(Todo t) {
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
    public static String to_str(Deadline d) {
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
    public static String to_str(Event e) {
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

    public static Todo from_str(String s) {
        // TODO !!!!! CuRRENTLY BUGGY !!!!! TODO
        String[] ss = s.split(DIVIDER);

        for (String s0 : ss) {
            System.out.println(s0);
        }

        Todo ans;
        switch (ss[0]) {
        case "t":
            ans = new Todo(ss[3]);
            break;
        case "d":
            ans = new Deadline(ss[2],ss[3]);
            break;
        case "e":
            ans = new Event(ss[2],ss[3],ss[4]);
            break;
        default:
            return null;
        }
        if (ss[1].equals("1")) {
            ans.setIsDone(true);
        }
        return ans;
    }

    public static void store_todos(ArrayList<Todo> tasks, String fn) {
        ArrayList<String> txts = new ArrayList<String>();
        // for
    }
}
