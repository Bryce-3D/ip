import java.util.ArrayList;

public class Ui {
    // Attributes/Fields ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public final static String INDENT = " ".repeat(4);
    public final static String DIVIDER = "~".repeat(80);

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
        for (int i = 0; i < Homura.getTodos().size(); i++) {
            // Converting int to string representation inspired by
            // https://stackoverflow.com/questions/5071040/
            // java-convert-integer-to-string
            numberedTasks.add((i+1) + ".) " + Homura.getTodos().get(i));
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
                + Homura.getTodos().size() + " tasks(s) in your list");
        printTodos();
        System.out.println(INDENT + DIVIDER + '\n');
    }
}
