public class Deadline extends  TODO {
    /*
    Attributes from ToDo
        str  description
        bool is_done
     */
    public String deadline;
    // TODO rename this to "by"

    public Deadline(String description, String deadline) {
        super(description);
        this.deadline = deadline;
    }

    public static Deadline parse(String inp) {
        try {
            inp = inp.substring(9);   // Remove the "deadline " in front
            String[] split_inp = inp.split(" /by ");
            String descr = split_inp[0];
            String deadline = split_inp[1];
            return new Deadline(descr, deadline);
        } catch (Exception e) {
            throw new InvalidInputException("deadline", inp);
        }
    }

    @Override
    public String toString() {
        String ans = "[D]";
        if (is_done) {
            ans += "[✓] ";
        } else {
            ans += "[ ] ";
        }
        ans += description + " (by: " + deadline + ")";
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
