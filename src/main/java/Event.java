public class Event extends ToDo {
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