import java.util.*;

public class Homura {
    public final static String indent = " ".repeat(4);
    public final static String divider =
        '★' + (
            "~".repeat(4) + '☆'
            + "~".repeat(4) + '★'
        ).repeat(8);
    public static ArrayList<ToDo> tasks = new ArrayList<ToDo>();

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

    public static String task_added_msg(ToDo t) {
        return indent + divider + '\n'
            + indent + " ToDo marked as done\n"
            + indent + ' ' + t + '\n'
            + indent + divider + '\n';
    }

    public static String task_removed_msg(ToDo t) {
        return indent + divider + '\n'
            + indent + " ToDo marked as not done\n"
            + indent + ' ' + t + '\n'
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

            // Mark a task on the list as done
            if (split_inp[0].equals("mark")) {
                // How to convert String to int inspired by
                // https://stackoverflow.com/questions/5585779/how-do-i-convert-a-string-to-an-int-in-java
                int i = Integer.parseInt(split_inp[1]) - 1;
                tasks.get(i).is_done = true;
                System.out.println(task_added_msg(tasks.get(i)));
                continue;
            }

            // Unmark a task on the list
            if (split_inp[0].equals("unmark")) {
                int i = Integer.parseInt(split_inp[1]) - 1;
                tasks.get(i).is_done = false;
                System.out.println(task_removed_msg(tasks.get(i)));
                continue;
            }

            // Add a TODO to the list
            if (split_inp[0].equals("todo")) {
                inp = inp.substring(5);
                ToDo t = new ToDo(inp);
                tasks.add(t);
                // TODO print out status of this when society eeeeeee
                System.out.println(t.mark_str());
                continue;
            }

            // Not a command
            // System.out.println((format_echo(inp)));
            System.out.println(indent + divider);
            System.out.println(indent + " nya~");
            System.out.println(indent + divider);
        }
    }
}

// RECYCLING BIN
/*
    public static String format_echo(String s) {
        return indent + divider + '\n'
            + indent + ' ' + s + '\n'
            + indent + divider + '\n';
    }
 */

// String concatenation inspired by
// https://stackoverflow.com/questions/523871/best-way-to-concatenate-list-of-string-objects


