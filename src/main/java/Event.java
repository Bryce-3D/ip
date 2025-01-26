public class Event extends Todo {
    /*
    Attributes from ToDo
        str  description
        bool isDone
     */
    private String sta;
    private String end;

    public Event(String description, String sta, String end) {
        super(description);
        this.sta = sta;
        this.end = end;
    }

    public String getSta() {
        return sta;
    }
    public String getEnd() {
        return end;
    }

    /**
     * Convert to a String representation for storage.
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

    @Override
    public String toString() {
        String ans = "[E]";
        if (getIsDone()) {
            ans += "[✓] ";
        } else {
            ans += "[ ] ";
        }
        ans += getDescription()
            + " (from: " + sta
            + " to: " + end + ")";
        return ans;
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