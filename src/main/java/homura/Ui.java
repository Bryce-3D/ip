package homura;

import java.util.ArrayList;

/**
 * A class for handling the UI by generating response messages.
 */
public class Ui {
    // Attributes/Fields ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public final static String INDENT = " ".repeat(4);

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
     * Generates a string to send when a Todo is created.
     *
     * @param t The created Todo.
     * @return The string to send when a Todo is created.
     */
    public static String addMsg(Todo t) {
        return t.getClass().getSimpleName() + " added" + '\n'
                + INDENT + t + '\n';
    }
    /**
     * Generates a string to send when a Todo is marked.
     *
     * @param t The created Todo.
     * @return The string to send when a Todo is marked.
     */
    public static String markMsg(Todo t) {
        return t.getClass().getSimpleName() + " marked as done" + '\n'
                + INDENT + t + '\n';
    }
    /**
     * Generates a string to send when a Todo is unmarked.
     *
     * @param t The  created Todo.
     * @return The string to send when a Todo is unmarked.
     */
    public static String unmarkMsg(Todo t) {
        return t.getClass().getSimpleName() + " marked as not done" + '\n'
                + INDENT + t + '\n';
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
        return Homura.getTodos().size() + " task(s) in your list" + '\n'
                + todosStr();
    }
    /**
     * Generates a UI string representing a list of todos from the find cmd.
     *
     * @param todos The list of todos being converted to a UI string.
     * @return The UI string representation of todos.
     */
    public static String foundTodosFormatted(ArrayList<Todo> todos) {
        return todos.size() + " task(s) found in your list" + '\n'
                + todosStr(todos);
    }
}
