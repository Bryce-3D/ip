/**
 * A class for handling the UI.
 */

// How to use and create packages inspired by
// https://github.com/weiseng18/ip/tree/master/src/main/java/panorama
// and
// https://www.w3schools.com/java/java_packages.asp
package homura;

import java.util.ArrayList;

public class Ui {
    // Attributes/Fields ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public final static String INDENT = " ".repeat(4);
    public final static String DIVIDER = "~".repeat(80);

    // CLI Version ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
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
    /**
     * Prints an arbitrary list of todos to the command line interface.
     *
     * @param todos The ArrayList of todos to print.
     */
    public static void printTodos(ArrayList<Todo> todos) {
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
     * Prints a found list of todos to the CLI with dividers.
     *
     * @param todos The ArrayList of todos to print.
     */
    public static void printFoundTodosFormatted(ArrayList<Todo> todos) {
        System.out.println(INDENT + DIVIDER);
        System.out.println(INDENT + " "
                + todos.size() + " tasks(s) found in your list");
        printTodos(todos);
        System.out.println(INDENT + DIVIDER + '\n');
    }

    // New JavaFX Version ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public static String introMsgJavafx() {
        return "Good morning Madoka-chan.\n"
                + "Did Kyuubey contact you last night?";
    }
    public static String byeMsgJavafx() {
        return "Kaname Madoka, do you treasure the life you currently live? "
                + "And do you consider your family and your friends precious?"
                + "\n"
                + "If that's the truth then you wouldn't try changing the "
                + "life you have or the person you are. Otherwise you'll "
                + "lose everything you love. Don't change, stay as you are, "
                + "Kaname Madoka. Stay as you are, forever."
                + '\n'
                + " Farewell."
                + '\n' + '\n'
                + "Send any message to close me.\n";
    }
    public static String todosStrJavafx() {
        ArrayList<String> numberedTasks = new ArrayList<String>();
        for (int i = 0; i < Homura.getTodos().size(); i++) {
            // Converting int to string representation inspired by
            // https://stackoverflow.com/questions/5071040/
            // java-convert-integer-to-string
            numberedTasks.add((i+1) + ".) " + Homura.getTodos().get(i));
        }
        String ans = "";
        for (String item : numberedTasks) {
            ans += INDENT + " " + item + '\n';
        }
        return ans;
    }

    public static String todosFormattedJavafx() {
        return Homura.getTodos().size() + " tasks(s) in your list" + '\n'
                + todosStrJavafx();
    }

    public static String foundTodosFormattedJavafx(ArrayList<Todo> todos) {
        return todos.size() + " tasks(s) found in your list" + '\n'
                + todosStrJavafx();
    }
}
