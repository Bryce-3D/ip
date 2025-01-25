import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {
    public static final String DIVIDER = " | ";

    /**
     * Returns the contents of a file as a String.
     * Returns null if the file does not exist.
     *
     * @param fn The filename.
     * @return The file contents or null.
     */
    public static String read_file(String fn) {
        File f = new File(fn);
        // How to read the contents of a file inspired by
        // https://stackoverflow.com/questions/72361778/how-can-i-get-java-to-read-all-text-in-file
        try {
            Scanner sc = new Scanner(f).useDelimiter("\\A");
            return sc.next();
        } catch (FileNotFoundException e) {
            return null;
        }
    }

    /**
     * Writes the String to a file.
     * Creates a file if it does not exist and overwrites an
     * existing file, if any.
     *
     * @param txt The text to write.
     * @param fn The filename.
     */
    public static void write_file(String txt, String fn) {
        File f = new File(fn);
        try {
            f.createNewFile();
        } catch (IOException e) {
        }
        try {
            FileWriter fw = new FileWriter(f);
            fw.write(txt);
            fw.close();
        } catch (IOException e) {
        }
    }

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

    public static void store_todos(ArrayList<Todo> tasks, String fn) {
        ArrayList<String> txts = new ArrayList<String>();
        // for
    }
}
