import java.util.ArrayList;
import java.util.Scanner;

public class Homura {
    public final static String indent = " ".repeat(4);
//    public final static String divider =
//        '★' + (
//            "~".repeat(4) + '☆'
//            + "~".repeat(4) + '★'
//        ).repeat(8);
    public final static String divider = "~".repeat(80);
    public static ArrayList<TODO> tasks = new ArrayList<TODO>();

    // How to read input inspired by
    // https://github.com/Bryce-3D/My-Codeforces-Codes/blob/main/Java/0001-0100/CF_0001A.java
    private static Scanner sc = new Scanner(System.in);

    public static String intro_msg() {
        return indent + divider + '\n'
            + indent + " Hi, I'm Akemi Homura.\n"
            + indent + " Have you seem Madoka anywhere?\n"
            + indent + divider + '\n';
    }

    public static String bye_msg() {
        return indent + divider + '\n'
            + indent + " No matter what, don't become a magical girl.\n"
            + indent + " Farewell.\n"
            + indent + divider;
    }

    public static void print_items() {
        ArrayList<String> numbered_items = new ArrayList<String>();
        for (int i = 0; i < tasks.size(); i++) {
            // Converting int to string representation inspired by
            // https://stackoverflow.com/questions/5071040/java-convert-integer-to-string
            numbered_items.add((i+1) + ".) " + tasks.get(i));
        }
        for (String item : numbered_items) {
            System.out.println(indent + " " + item);
        }
    }

    public static void print_items_formatted() {
        System.out.println(indent + divider);
        System.out.println(indent + " " + tasks.size() + " tasks(s) in your list");
        print_items();
        System.out.println(indent + divider + '\n');
    }

    public static void cmd_mark(String inp) {
        // How to convert String to int inspired by
        // https://stackoverflow.com/questions/5585779/how-do-i-convert-a-string-to-an-int-in-java
        String[] split_inp = inp.split(" ");
        int i = Integer.parseInt(split_inp[1]) - 1;
        tasks.get(i).is_done = true;
        System.out.println(tasks.get(i).mark_str());
        System.out.println('\n');
    }

    public static void cmd_unmark(String inp) {
        String[] split_inp = inp.split(" ");
        int i = Integer.parseInt(split_inp[1]) - 1;
        tasks.get(i).is_done = false;
        System.out.println(tasks.get(i).unmark_str());
        System.out.println('\n');
    }

    public static void cmd_todo(String inp) {
        TODO t = TODO.parse(inp);
        tasks.add(t);
        System.out.println(t.add_str());
        System.out.println(
            indent + " " + tasks.size() + " task(s) in your list" + '\n'
                + indent + divider + '\n'
        );
    }

    public static void cmd_deadline(String inp) {
        Deadline d = Deadline.parse(inp);
        tasks.add(d);
        System.out.println(d.add_str());
        System.out.println(
            indent + " " + tasks.size() + " task(s) in your list" + '\n'
                + indent + divider + '\n'
        );
    }

    public static void cmd_event(String inp) {
        Event e = Event.parse(inp);
        tasks.add(e);
        System.out.println(e.add_str());
        System.out.println(
            indent + " " + tasks.size() + " task(s) in your list" + '\n'
                + indent + divider + '\n'
        );
    }

    public static void cmd_delete(String inp) {
        String[] split_inp = inp.split(" ");
        int i = Integer.parseInt(split_inp[1]) - 1;
        if (i >= tasks.size()) {
            throw new InvalidInputHomuraException("delete", inp);
        }
        TODO t = tasks.get(i);
        tasks.remove(i);
        System.out.println(
            indent + divider + '\n'
                + indent + " " + t.getClass().getSimpleName() + " removed" + '\n'
                + indent + indent + t + '\n'
                + indent + " " + tasks.size() + " tasks(s) in your list" + '\n'
                + indent + divider + '\n'
        );
    }

    public static void main(String[] args) {
        System.out.println(intro_msg());
        while (true) {
            // How to read input inspired by
            // https://github.com/Bryce-3D/My-Codeforces-Codes/blob/main/Java/0001-0100/CF_0001A.java
            String inp = sc.nextLine();

            // Exit the chatbot
            if (inp.equals("bye")) {
                System.out.println(bye_msg());
                break;
            }

            // List items in the TODO list
            if (inp.equals("list")) {
                print_items_formatted();
                continue;
            }

            String[] split_inp = inp.split(" ");
            String cmd = split_inp[0].toLowerCase();

            // Mark a todo on the list
            if (cmd.equals("mark")) {
                cmd_mark(inp);
                continue;
            }

            // Unmark a todo on the list
            if (cmd.equals("unmark")) {
                cmd_unmark(inp);
                continue;
            }

            // Add a TODO to the list
            if (cmd.equals("todo")) {
                cmd_todo(inp);
                continue;
            }

            // Add a deadline to the list
            if (cmd.equals("deadline")) {
                cmd_deadline(inp);
                continue;
            }

            // Add an event to the list
            if (cmd.equals("event")) {
                cmd_event(inp);
                continue;
            }

            // Remove an event from the list
            if (cmd.equals("delete")) {
                cmd_deadline(inp);
                continue;
            }

            // Not a command
            throw new InvalidCmdHomuraException(cmd);
        }
    }
}

// RECYCLING BIN ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//            // Not a command
//            // System.out.println((format_echo(inp)));
//            System.out.println(indent + divider);
//            System.out.println(indent + " nya~");
//            System.out.println(indent + divider);
//            System.out.println();

/*
    public static String format_echo(String s) {
        return indent + divider + '\n'
            + indent + ' ' + s + '\n'
            + indent + divider + '\n';
    }
 */
/*
    public static String task_added_msg(ToDo t) {
        return indent + divider + '\n'
            + indent + " ToDo marked as done\n"
            + indent + ' ' + t + '\n'
            + indent + divider + '\n';
    }
 */
/*
    public static String task_removed_msg(ToDo t) {
        return indent + divider + '\n'
            + indent + " ToDo marked as not done\n"
            + indent + ' ' + t + '\n'
            + indent + divider + '\n';
    }
 */

// String concatenation inspired by
// https://stackoverflow.com/questions/523871/best-way-to-concatenate-list-of-string-objects
