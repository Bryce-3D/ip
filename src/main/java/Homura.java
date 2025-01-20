import java.util.*;

public class Homura {
    public final static String indent = " ".repeat(4);
    public final static String divider =
        '★' + (
            "~".repeat(4) + '☆'
            + "~".repeat(4) + '★'
        ).repeat(8);
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
            + indent + divider + '\n';
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
        print_items();
        System.out.println(indent + divider + '\n');
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
                // How to convert String to int inspired by
                // https://stackoverflow.com/questions/5585779/how-do-i-convert-a-string-to-an-int-in-java
                int i = Integer.parseInt(split_inp[1]) - 1;
                tasks.get(i).is_done = true;
                System.out.println(tasks.get(i).mark_str());
                // System.out.println(task_added_msg(tasks.get(i)));
                continue;
            }

            // Unmark a todo on the list
            if (cmd.equals("unmark")) {
                int i = Integer.parseInt(split_inp[1]) - 1;
                tasks.get(i).is_done = false;
                System.out.println(tasks.get(i).unmark_str());
                // System.out.println(task_removed_msg(tasks.get(i)));
                continue;
            }

            // Add a TODO to the list
            if (cmd.equals("todo")) {
                inp = inp.substring(5);
                TODO t = new TODO(inp);
                tasks.add(t);
                System.out.println(t.add_str());
                continue;
            }

            // Add a deadline to the list
            if (cmd.equals("deadline")) {
                inp = inp.substring(9);
                split_inp = inp.split(" /by ");
                String descr = split_inp[0];
                String deadline = split_inp[1];
                Deadline d = new Deadline(descr, deadline);
                tasks.add(d);
                System.out.println(d.add_str());
                continue;
            }

            // Add an event to the list
            if (cmd.equals("event")) {
                inp = inp.substring(6);
                split_inp = inp.split(" /from ");
                String descr = split_inp[0];
                split_inp = split_inp[1].split(" /to ");
                String sta = split_inp[0];
                String end = split_inp[1];
                Event e = new Event(descr, sta, end);
                tasks.add(e);
                System.out.println(e.add_str());
                continue;
            }

            // Not a command
            // System.out.println((format_echo(inp)));
            System.out.println(indent + divider);
            System.out.println(indent + " nya~");
            System.out.println(indent + divider);
            System.out.println();
        }
    }
}

// RECYCLING BIN ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
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
