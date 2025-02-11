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

    /**
     * Generates the message on bot startup.
     *
     * @return The message on bot startup.
     */
    public static String introMsg() {
        return "Good morning Madoka-chan.\n"
                + "Did Kyuubey contact you last night?";
    }
    /**
     * Generates the message on bot shutdown.
     *
     * @return The message on bot shutdown.
     */
    public static String byeMsg() {
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
    /**
     * Generates a UI string representing an arbitrary list of todos.
     *
     * @param todos The list of todos being converted to a UI string.
     * @return The UI string representation of todos.
     */
    public static String todosStr(ArrayList<Todo> todos) {
        ArrayList<String> numberedTasks = new ArrayList<String>();
        for (int i = 0; i < todos.size(); i++) {
            numberedTasks.add((i+1) + ".) " + todos.get(i));
        }
        String ans = "";
        for (String item: numberedTasks) {
            ans += INDENT + " " + item + '\n';
        }
        return ans;
    }
    /**
     * Generates a UI string for the stored list of todos.
     *
     * @return The UI string representation of todos.
     */
    public static String todosStr() {
        return todosStr(Homura.getTodos().getTodos());
    }
    /**
     * Generates a UI string representing a list of todos from the list cmd.
     *
     * @return The UI string representation of todos.
     */
    public static String listTodosFormatted() {
        return Homura.getTodos().size() + " tasks(s) in your list" + '\n'
                + todosStr();
    }
    /**
     * Generates a UI string representing a list of todos from the find cmd.
     *
     * @param todos The list of todos being converted to a UI string.
     * @return The UI string representation of todos.
     */
    public static String foundTodosFormatted(ArrayList<Todo> todos) {
        return todos.size() + " tasks(s) found in your list" + '\n'
                + todosStr(todos);
    }
}
