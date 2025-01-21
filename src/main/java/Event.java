public class Event extends TODO {
    /*
    Attributes from ToDo
        str  description
        bool is_done
     */
    public String sta;
    public String end;

    public Event(String description, String sta, String end) {
        super(description);
        this.sta = sta;
        this.end = end;
    }

    public static Event parse(String inp) {
        try {
            inp = inp.substring(6);   // Remove the "event " in front
            String[] split_inp = inp.split(" /from ");
            String descr = split_inp[0];
            split_inp = split_inp[1].split(" /to ");
            String sta = split_inp[0];
            String end = split_inp[1];
            return new Event(descr, sta, end);
        } catch (Exception e) {
            throw new InvalidInputHomuraException("event", inp);
        }
    }

    @Override
    public String toString() {
        String ans = "[E]";
        if (is_done) {
            ans += "[✓] ";
        } else {
            ans += "[ ] ";
        }
        ans += description
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