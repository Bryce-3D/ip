import java.util.ArrayList;
import java.util.Scanner;

public class Homura {
    // Attributes/Fields ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public final static String INDENT = " ".repeat(4);
    public final static String DIVIDER = "~".repeat(80);
    public final static String TODOS_FILENAME = "HomuraTodos.txt";

    // How to read input inspired by
    // https://github.com/Bryce-3D/My-Codeforces-Codes/blob/
    // main/Java/0001-0100/CF_0001A.java
    private final static Scanner SC = new Scanner(System.in);
    private static ArrayList<Todo> todos = new ArrayList<Todo>();


    // Bot Messages ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    /**
     * Generates the message on bot startup.
     *
     * @return The message on bot startup.
     */
    public static String introMsg() {
        return INDENT + DIVIDER + '\n'
                + INDENT + " Hi, I'm Akemi Homura.\n"
                + INDENT + " Have you seem Madoka anywhere?\n"
                + INDENT + DIVIDER + '\n';
    }
    /**
     * Generates the message on bot shutdown.
     *
     * @return The message on bot shutdown.
     */
    public static String byeMsg() {
        return INDENT + DIVIDER + '\n'
                + INDENT + " No matter what, don't become a magical girl.\n"
                + INDENT + " Farewell.\n"
                + INDENT + DIVIDER;
    }
    /**
     * Prints the todos to the command line interface.
     */
    public static void printTodos() {
        ArrayList<String> numberedTasks = new ArrayList<String>();
        for (int i = 0; i < todos.size(); i++) {
            // Converting int to string representation inspired by
            // https://stackoverflow.com/questions/5071040/
            // java-convert-integer-to-string
            numberedTasks.add((i+1) + ".) " + todos.get(i));
        }
        for (String item : numberedTasks) {
            System.out.println(INDENT + " " + item);
        }
    }
    /**
     * Prints the todos to the command line interface with dividers.
     */
    public static void printTodosFormatted() {
        System.out.println(INDENT + DIVIDER);
        System.out.println(INDENT + " "
                + todos.size() + " tasks(s) in your list");
        printTodos();
        System.out.println(INDENT + DIVIDER + '\n');
    }


    // Bot on/off logic ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    /**
     * Turn the bot on.
     */
    public static void on() {
        todos = Storage.readTodos(TODOS_FILENAME);
        System.out.println(introMsg());
    }

    /**
     * Turn the bot off.
     */
    public static void off() {
        Storage.writeTodos(todos, TODOS_FILENAME);
        System.out.println(byeMsg());
    }


    // Bot commands logic ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    /**
     * Handles the logic of the mark command.
     *
     * @param inp The full line of input to the bot.
     */
    public static void cmdMark(String inp) {
        // How to convert String to int inspired by
        // https://stackoverflow.com/questions/5585779/
        // how-do-i-convert-a-string-to-an-int-in-java
        String[] splitInps = inp.split(" ");
        int i = Integer.parseInt(splitInps[1]) - 1;
        todos.get(i).setIsDone(true);
        System.out.println(todos.get(i).markStr());
        System.out.println('\n');
    }
    /**
     * Handles the logic of the unmark command.
     *
     * @param inp The full line of input to the bot.
     */
    public static void cmdUnmark(String inp) {
        String[] splitInps = inp.split(" ");
        int i = Integer.parseInt(splitInps[1]) - 1;
        todos.get(i).setIsDone(false);
        System.out.println(todos.get(i).unmarkStr());
        System.out.println('\n');
    }
    /**
     * Handles the logic of the todo command.
     *
     * @param inp The full line of input to the bot.
     */
    public static void cmdTodo(String inp) {
        Todo t = Todo.parse(inp);
        todos.add(t);
        System.out.println(t.addStr());
        System.out.println(
                INDENT + " " + todos.size()
                + " task(s) in your list" + '\n'
                + INDENT + DIVIDER + '\n'
        );
    }
    /**
     * Handles the logic of the deadline command.
     *
     * @param inp The full line of input to the bot.
     */
    public static void cmdDeadline(String inp) {
        Deadline d = Deadline.parse(inp);
        todos.add(d);
        System.out.println(d.addStr());
        System.out.println(
                INDENT + " " + todos.size() + " task(s) in your list" + '\n'
                + INDENT + DIVIDER + '\n'
        );
    }
    /**
     * Handles the logic of the event command.
     *
     * @param inp The full line of input to the bot.
     */
    public static void cmdEvent(String inp) {
        Event e = Event.parse(inp);
        todos.add(e);
        System.out.println(e.addStr());
        System.out.println(
                INDENT + " " + todos.size() + " task(s) in your list" + '\n'
                + INDENT + DIVIDER + '\n'
        );
    }
    /**
     * Handles the logic of the delete command.
     *
     * @param inp The full line of input to the bot.
     */
    public static void cmdDelete(String inp) {
        String[] splitInps = inp.split(" ");
        int i = Integer.parseInt(splitInps[1]) - 1;
        if (i >= todos.size()) {
            throw new InvalidInputHomuraException("delete", inp);
        }
        Todo t = todos.get(i);
        todos.remove(i);
        System.out.println(
                INDENT + DIVIDER + '\n'
                + INDENT + " " + t.getClass().getSimpleName()
                + " removed" + '\n'
                + INDENT + INDENT + t + '\n'
                + INDENT + " " + todos.size()
                + " tasks(s) in your list" + '\n'
                + INDENT + DIVIDER + '\n'
        );
    }





    // Main ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public static void main(String[] args) {
        System.out.println(introMsg());
        while (true) {
            // How to read input inspired by
            // https://github.com/Bryce-3D/My-Codeforces-Codes/blob/main/
            // Java/0001-0100/CF_0001A.java
            String inp = SC.nextLine();

            // Exit the chatbot
            if (inp.equals("bye")) {
                System.out.println(byeMsg());
                break;
            }

            // List items in the Todo list
            if (inp.equals("list")) {
                printTodosFormatted();
                continue;
            }

            String[] splitInps = inp.split(" ");
            String cmd = splitInps[0].toLowerCase();

            switch (cmd) {
            case "mark":   // Mark a Todo on the list
                cmdMark(inp);
                break;
            case "unmark":   // Unmark a Todo on the list
                cmdUnmark(inp);
                break;
            case "todo":   // Add a Todo to the list
                cmdTodo(inp);
                break;
            case "deadline":   // Add a deadline to the list
                cmdDeadline(inp);
                break;
            case "event":   // Add an event to the list
                cmdEvent(inp);
                break;
            case "delete":   // Remove an event from the list
                cmdDelete(inp);
                break;
            default:   // Not a command
                throw new InvalidCmdHomuraException(cmd);
            }
        }
    }
}

// RECYCLING BIN ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
/*
    public final static String divider =
        '★' + (
            "~".repeat(4) + '☆'
            + "~".repeat(4) + '★'
        ).repeat(8);
 */

/*
            // Mark a todo on the list
            if (cmd.equals("mark")) {
                // cmd_mark(inp);
                continue;
            }

            // Unmark a todo on the list
            if (cmd.equals("unmark")) {
                // cmd_unmark(inp);
                continue;
            }

            // Add a Todo to the list
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
 */

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
