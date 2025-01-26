import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Event extends Todo {
    /*
    Attributes from ToDo
        str  description
        bool isDone
     */
    private LocalDate sta;
    private LocalDate end;

    public static final DateTimeFormatter dtfParse
            = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public static final DateTimeFormatter dtfToString
            = DateTimeFormatter.ofPattern("MMM dd yyyy");
    public static final DateTimeFormatter dtfToStorage
            = DateTimeFormatter.ofPattern("yyyy-MM-dd");

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

    public LocalDate getSta() {
        return sta;
    }
    public LocalDate getEnd() {
        return end;
    }

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
     * Converts a storage string representation to an Event.
     *
     * @param s The storage string.
     * @return The Event.
     */
    public static Event fromStorageStr(String s) {
        ArrayList<String> ss = HomuraUtils.split(s, Storage.DIVIDER);
        Event ans = new Event(ss.get(2),ss.get(3),ss.get(4));
        if (ss.get(1).equals("1")) {
            ans.setIsDone(true);
        }
        return ans;
    }
    /**
     * Converts to a String representation for storage.
     * The current format is `e | 0 or 1 | descr | sta | end`.
     *
     * @return The storage representation.
     */
    @Override
    public String toStorageStr() {
        String ans = "e" + Storage.DIVIDER;
        if (getIsDone()) {
            ans += 1;
        } else {
            ans += 0;
        }
        ans += Storage.DIVIDER + getDescription()
                + Storage.DIVIDER + sta
                + Storage.DIVIDER + end;
        return ans;
    }

    public static Event parse(String inp) {
        inp = inp.strip();
        if (inp.length() <= 6) {
            throw new EmptyInputHomuraException("Todo", inp);
        }
        try {
            inp = inp.substring(6);   // Remove the "event " in front
            String[] splitInps = inp.split(" /from ");
            String descr = splitInps[0];
            splitInps = splitInps[1].split(" /to ");
            String sta = splitInps[0];
            String end = splitInps[1];
            return new Event(descr, sta, end);
        } catch (Exception e) {
            throw new InvalidInputHomuraException("event", inp);
        }
    }
}

// Recycling Bin ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
/*
    @Override
    public String mark_str() {
        return indent + divider + '\n'
            + indent + " Event marked as done" + '\n'
            + indent + " " + this.toString() + '\n'
            + indent + divider + '\n';
    }
 */
/*
    @Override
    public String unmark_str() {
        return indent + divider + '\n'
            + indent + "Event marked as not done" + '\n'
            + indent + " " + this.toString() + '\n'
            + indent + divider + '\n';
    }
 */