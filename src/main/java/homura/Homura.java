/**
 * A class for the main logic of the chatbot Homura.
 */

// How to use and create packages inspired by
// https://github.com/weiseng18/ip/tree/master/src/main/java/panorama
// and
// https://www.w3schools.com/java/java_packages.asp
package homura;

import java.util.ArrayList;

public class Homura {
    // Attributes + Getters and Setters ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public final static String INDENT = " ".repeat(4);
    public final static String TODOS_FILENAME = "HomuraTodos.txt";

    private static TaskList todos = new TaskList();

    public static TaskList getTodos() {
        return todos;
    }
    public static void setTodos(TaskList todos) {
        Homura.todos = todos;
    }



    // Bot commands logic ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    /**
     * Handles the logic of the todo command.
     *
     * @param inp The full line of input to the bot.
     * @return The String that the bot should send in response.
     */
    public static String cmdTodo(String inp) {
        Todo t = Parser.parseTodoInp(inp);
        todos.add(t);
        return t.addStrJavafx();
    }
    /**
     * Handles the logic of the deadline command.
     *
     * @param inp The full line of input to the bot.
     * @return The String that the bot should send in response.
     */
    public static String cmdDeadline(String inp) {
        Deadline d = Parser.parseDeadlineInp(inp);
        todos.add(d);
        return d.addStrJavafx();
    }
    /**
     * Handles the logic of the event command.
     *
     * @param inp The full line of input to the bot.
     * @return The String that the bot should send in response.
     */
    public static String cmdEvent(String inp) {
        assert inp.strip().toLowerCase().startsWith("event");
        Event e = Parser.parseEventInp(inp);
        todos.add(e);
        return e.addStrJavafx();
    }
    /**
     * Handles the logic of the edit command.
     *
     * @param inp The full line of input to the bot.
     * @return The String that the bot should send in response.
     */
    public static String cmdEdit(String inp) {
        // Input format should be of the form
        // edit 1 /des asdf /by 2025-01-01 /from 2025-01-01 /to 2025-01-01
        assert inp.strip().toLowerCase().startsWith("edit");
        // Inspired by the ChatGPT query
        // Hi! How can I check if a string contains a character in Java? Thanks!
        if (!inp.contains("/")) {
            throw new InvalidInputHomuraException("edit", inp);
        }
        String[] splitSpaceInps = inp.split(" +");   // + handles whitespace spam
        int ind = Integer.parseInt(splitSpaceInps[1]) - 1;
        Todo t = todos.get(ind);

        ArrayList<String> splitSlashInps = HomuraUtils.split(inp,"/");
        String next, attr, newVal;
        for (int i = 1; i < splitSlashInps.size(); i++) {
            next = splitSlashInps.get(i);
            attr = next.split(" ")[0];
            newVal = next.substring(attr.length()+1).strip();
            try {
                t.edit(attr, newVal);
            } catch (HomuraRuntimeException e) {
                throw new InvalidInputHomuraException("edit", inp);
            }
        }

        return t.getClass().getSimpleName() + " " + (ind + 1)
                + " successfully modified" + '\n'
                + INDENT + t;
    }

    /**
     * Handles the logic of the mark command.
     *
     * @param inp The full line of input to the bot.
     * @return The String that the bot should send in response.
     */
    public static String cmdMark(String inp) {
        assert inp.strip().toLowerCase().startsWith("mark");
        // How to convert String to int inspired by
        // https://stackoverflow.com/questions/5585779/
        // how-do-i-convert-a-string-to-an-int-in-java
        String[] splitInps = inp.split(" ");
        int i = Integer.parseInt(splitInps[1]) - 1;
        todos.get(i).setIsDone(true);
        return todos.get(i).markStrJavafx();
    }
    /**
     * Handles the logic of the unmark command.
     *
     * @param inp The full line of input to the bot.
     * @return The String that the bot should send in response.
     */
    public static String cmdUnmark(String inp) {
        assert inp.strip().toLowerCase().startsWith("unmark");
        String[] splitInps = inp.split(" ");
        int i = Integer.parseInt(splitInps[1]) - 1;
        todos.get(i).setIsDone(false);
        return todos.get(i).unmarkStrJavafx();
    }
    /**
     * Handles the logic of the delete command.
     *
     * @param inp The full line of input to the bot.
     * @return The String that the bot should send in response.
     */
    public static String cmdDelete(String inp) {
        assert inp.strip().toLowerCase().startsWith("delete");
        String[] splitInps = inp.split(" ");
        int i = Integer.parseInt(splitInps[1]) - 1;
        if (i >= todos.size()) {
            throw new InvalidInputHomuraException("delete", inp);
        }
        Todo t = todos.get(i);
        todos.remove(i);
        return t.getClass().getSimpleName()
                + " removed" + '\n'
                + INDENT + t + '\n'
                + todos.size() + " tasks(s) in your list";
    }

    /**
     * Handles the logic of the list command.
     *
     * @param inp The full line of input to the bot.
     * @return The String that the bot should send in response.
     */
    public static String cmdList(String inp) {
        assert inp.strip().toLowerCase().startsWith("list");
        return Ui.listTodosFormatted();
    }
    /**
     * Handles the logic of the find command.
     *
     * @param inp The full line of input to the bot.
     * @return The String that the bot should send in response.
     */
    public static String cmdFind(String inp) {
        assert inp.strip().toLowerCase().startsWith("find");
        String[] splitInps = inp.split(" ");
        String s = splitInps[1];
        ArrayList<Todo> matches = todos.findTodosWith(s);
        return Ui.foundTodosFormatted(matches);
    }

    /**
     * Handles the logic of the bye command.
     *
     * @param inp The full line of input to the bot.
     * @return The String that the bot should send in response.
     */
    public static String cmdBye(String inp) {
        assert inp.strip().toLowerCase().startsWith("bye");
        Storage.writeTodos(todos, TODOS_FILENAME);
        return Ui.byeMsg();
    }

    /**
     * Handles the logic of a single command passed to the bot.
     *
     * @param inp The full line of input to the bot.
     * @return The String that the bot should send in response.
     */
    public static String cmd(String inp) {
        String[] splitInps = inp.split(" ");
        String cmd = splitInps[0].toLowerCase();

        switch (cmd) {
        case "bye":   // Say goodbye to Homura
            return cmdBye(inp);
        case "list":   // List out all Todos
            return cmdList(inp);
        case "mark":   // Mark a Todo on the list
            return cmdMark(inp);
        case "unmark":   // Unmark a Todo on the list
            return cmdUnmark(inp);
        case "todo":   // Add a Todo to the list
            return cmdTodo(inp);
        case "deadline":   // Add a deadline to the list
            return cmdDeadline(inp);
        case "event":   // Add an event to the list
            return cmdEvent(inp);
        case "edit":   // Edit an entry in the list
            return cmdEdit(inp);
        case "delete":   // Remove an event from the list
            return cmdDelete(inp);
        case "find":   // Find todos in the list with some text
            return cmdFind(inp);
        default:   // Not a command
            throw new InvalidCmdHomuraException(cmd);
        }
    }
}
