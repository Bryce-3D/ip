import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

public class Deadline extends Todo {
    /*
    Attributes from ToDo
        str  description
        bool isDone
     */
    private LocalDate by;

    public static final DateTimeFormatter dtfParse
            = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public static final DateTimeFormatter dtfToString
            = DateTimeFormatter.ofPattern("MMM dd yyyy");
    public static final DateTimeFormatter dtfToStorage
            = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public Deadline(String description, LocalDate by) {
        super(description);
        this.by = by;
    }

    public Deadline(String description, String byStr) {
        super(description);
        by = LocalDate.parse(byStr, dtfParse);
    }

    public LocalDate getBy() {
        return by;
    }

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
     * Converts a storage string representation to a Deadline.
     *
     * @param s The storage string.
     * @return The Deadline.
     */
    public static Deadline fromStorageStr(String s) {
        ArrayList<String> ss = HomuraUtils.split(s, Storage.DIVIDER);
        Deadline ans = new Deadline(ss.get(2),ss.get(3));
        if (ss.get(1).equals("1")) {
            ans.setIsDone(true);
        }
        return ans;
    }
    /**
     * Converts to a String representation for storage.
     * The current format is `d | 0 or 1 | descr | by`.
     *
     * @return The storage representation.
     */
    @Override
    public String toStorageStr() {
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
    // TODO
    /*
    - Implement a fromStorageStr() function
    - Replicate similar updates to Event.java
    - Also implement fromStorageStr() in Todo.java
    - Update how Storage.readTodos() words (likely deprecating
      Storage.fromStr() in the process)
     */

    public static Deadline parse(String inp) {
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


}

// Recycling Bin ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
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
