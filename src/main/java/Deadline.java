public class Deadline extends Todo {
    /*
    Attributes from ToDo
        str  description
        bool isDone
     */
    private String deadline;
    // Todo rename this to "by"

    public Deadline(String description, String deadline) {
        super(description);
        this.deadline = deadline;
    }

    public static Deadline parse(String inp) {
        inp = inp.strip();
        if (inp.length() <= 9) {
            throw new EmptyInputHomuraException("Todo", inp);
        }
        try {
            inp = inp.substring(9);   // Remove the "deadline " in front
            String[] splitInps = inp.split(" /by ");
            String descr = splitInps[0];
            String deadline = splitInps[1];
            return new Deadline(descr, deadline);
        } catch (Exception e) {
            throw new InvalidInputHomuraException("deadline", inp);
        }
    }

    @Override
    public String toString() {
        String ans = "[D]";
        if (getIsDone()) {
            ans += "[✓] ";
        } else {
            ans += "[ ] ";
        }
        ans += getDescription() + " (by: " + deadline + ")";
        return ans;
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
