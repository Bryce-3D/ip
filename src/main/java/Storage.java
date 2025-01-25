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
    public static String todoToStr(Todo t) {
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
    public static String deadlineToStr(Deadline d) {
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
     * Convert an Event to a String representation for storage.
     * The current format is `e | 0 or 1 | descr | sta | end`
     *
     * @param e The Event to store.
     * @return The storage representation of e.
     */
    public static String eventToStr(Event e) {
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
     * Convert a Todo or any of its subclasses to its storage String.
     *
     * @param t The Todo or its subclass to store.
     * @return The storage representation of t.
     */
    public static String toStr(Todo t) {
        // How to check the type of an object inspired by ChatGPT with
        // the query "Hi! How do I check whether a  variable is of a
        // given type in Java?"
        if (t instanceof Event) {
            return eventToStr((Event) t);
        } else if (t instanceof Deadline) {
            return deadlineToStr((Deadline) t);
        } else {
            return todoToStr(t);
        }
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


    // Functions to read/write the Todos ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    /**
     * Read a list of Todos from a file.
     * Returns an empty list if the file does not exist.
     *
     * @param fn The file name being read from.
     * @return The ArrayList of Todos.
     */
    public static ArrayList<Todo> readTodos(String fn) {
        String ftxt = HomuraUtils.readFile(fn);
        if (ftxt == null) {
            return new ArrayList<Todo>();
        }
        ArrayList<String> txts = HomuraUtils.split(ftxt, "\n");
        ArrayList<Todo> ans = new ArrayList<Todo>();
        for (String txt : txts) {
            ans.add(fromStr(txt));
        }
        return ans;
    }
    /**
     * Write a list of Todos to a file.
     * Will overwrite the given file if it already exists.
     *
     * @param tasks The Todos to write.
     * @param fn The filename being written to.
     */
    public static void writeTodos(ArrayList<Todo> tasks, String fn) {
        ArrayList<String> txts = new ArrayList<String>();
        for (Todo t : tasks) {
            txts.add(toStr(t));
        }
        // String concatenation inspired by
        // https://stackoverflow.com/questions/523871/
        // best-way-to-concatenate-list-of-string-objects
        String txt = String.join("\n", txts);
        HomuraUtils.writeFile(txt,fn);
    }
}
