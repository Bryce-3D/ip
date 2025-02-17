package homura;

import java.util.ArrayList;

/**
 * A class for the main logic of the chatbot Homura.
 */
public class Homura {
    // Attributes + Getters and Setters ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public final static String INDENT = " ".repeat(4);
    public final static String TODOS_FILENAME = "HomuraTodos.txt";
    public final static String DEFAULT_ERR_MSG
            = "Sorry, but that is an invalid input to the command";

    private static TaskList todos = new TaskList();

    public static TaskList getTodos() {
        return todos;
    }
    public static void setTodos(TaskList todos) {
        Homura.todos = todos;
    }

    // Creating Todos ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    /**
     * Handles the logic of the todo command.
     *
     * @param inp The full line of input to the bot.
     * @return The String that the bot should send in response.
     */
    public static String cmdTodo(String inp) {
        assert inp.strip().toLowerCase().startsWith("todo");
        try {
            Todo t = Parser.parseTodoInp(inp);
            todos.add(t);
            return Ui.addMsg(t);
        } catch (Exception e) {
            return DEFAULT_ERR_MSG + '\n'
                    + "Input format should be" + '\n'
                    + INDENT + "todo <description>";
        }
    }
    /**
     * Handles the logic of the deadline command.
     *
     * @param inp The full line of input to the bot.
     * @return The String that the bot should send in response.
     */
    public static String cmdDeadline(String inp) {
        assert inp.strip().toLowerCase().startsWith("deadline");
        try {
            Deadline d = Parser.parseDeadlineInp(inp);
            todos.add(d);
            return Ui.addMsg(d);
        } catch (Exception e) {
            return DEFAULT_ERR_MSG + '\n'
                    + "Input format should be" + '\n'
                    + INDENT + "deadline <description> /by YYYY-MM-DD";
        }
    }
    /**
     * Handles the logic of the event command.
     *
     * @param inp The full line of input to the bot.
     * @return The String that the bot should send in response.
     */
    public static String cmdEvent(String inp) {
        assert inp.strip().toLowerCase().startsWith("event");
        try {
            Event e = Parser.parseEventInp(inp);
            todos.add(e);
            return Ui.addMsg(e);
        } catch (Exception e) {
            return DEFAULT_ERR_MSG + '\n'
                    + "Input format should be" + '\n'
                    + INDENT + "event <description> "
                    + "/from YYYY-MM-DD /to YYYY-MM-DD";
        }
    }

    // Modifying Todos ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    /**
     * Handles the logic of the mark command.
     *
     * @param inp The full line of input to the bot.
     * @return The String that the bot should send in response.
     */
    public static String cmdMark(String inp) {
        assert inp.strip().toLowerCase().startsWith("mark");
        try {
            // How to convert String to int inspired by
            // https://stackoverflow.com/questions/5585779/
            // how-do-i-convert-a-string-to-an-int-in-java
            String[] splitInps = inp.split(" ");
            int i = Integer.parseInt(splitInps[1]) - 1;
            todos.get(i).setIsDone(true);
            return Ui.markMsg(todos.get(i));
        } catch (Exception e) {
            return DEFAULT_ERR_MSG + '\n'
                    + "Input format should be" + '\n'
                    + INDENT + "mark <index>";
        }
    }
    /**
     * Handles the logic of the unmark command.
     *
     * @param inp The full line of input to the bot.
     * @return The String that the bot should send in response.
     */
    public static String cmdUnmark(String inp) {
        assert inp.strip().toLowerCase().startsWith("unmark");
        try {
            String[] splitInps = inp.split(" ");
            int i = Integer.parseInt(splitInps[1]) - 1;
            todos.get(i).setIsDone(false);
            return Ui.unmarkMsg(todos.get(i));
        } catch (Exception e) {
            return DEFAULT_ERR_MSG + '\n'
                    + "Input format should be" + '\n'
                    + INDENT + "unmark <index>";
        }
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

        try {
            String[] splitSpaceInps = inp.split(" +");
            int ind = Integer.parseInt(splitSpaceInps[1]) - 1;
            if (ind >= todos.size()) {
                return "Sorry, index out of range";
            }
            Todo t = todos.get(ind);
            if (!inp.contains("/")) {
                return "Nothing was edited.";
            }

            ArrayList<String> splitSlashInps = HomuraUtils.split(inp, "/");
            String next, attr, newVal;
            for (int i = 1; i < splitSlashInps.size(); i++) {
                next = splitSlashInps.get(i);
                attr = next.split(" ")[0];
                newVal = next.substring(attr.length() + 1).strip();
                t.edit(attr, newVal);
            }

            return t.getClass().getSimpleName() + " " + (ind + 1)
                    + " successfully modified" + '\n'
                    + INDENT + t;
        } catch (Exception e) {
            return DEFAULT_ERR_MSG + '\n'
                    + "Input format should be" + '\n'
                    + INDENT + "edit <index> [/<attr> <new_val>]*";
        }
    }
    /**
     * Handles the logic of the delete command.
     *
     * @param inp The full line of input to the bot.
     * @return The String that the bot should send in response.
     */
    public static String cmdDelete(String inp) {
        assert inp.strip().toLowerCase().startsWith("delete");
        try {
            String[] splitInps = inp.split(" ");
            int i = Integer.parseInt(splitInps[1]) - 1;
            if (i >= todos.size()) {
                return "Sorry, index out of range";
            }
            Todo t = todos.get(i);
            todos.remove(i);
            return t.getClass().getSimpleName()
                    + " removed" + '\n'
                    + INDENT + t + '\n'
                    + todos.size() + " tasks(s) in your list";
        } catch (Exception e) {
            return DEFAULT_ERR_MSG + '\n'
                    + "Input format should be" + '\n'
                    + INDENT + "delete <index>";
        }
    }

    // Listing Todos ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
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
        String s = inp.strip().substring(5).strip();
        ArrayList<Todo> matches = todos.findTodosWith(s);
        return Ui.foundTodosFormatted(matches);
    }

    // Bai~ and Misc ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
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
     * Handles the logic of an invalid command.
     *
     * @param cmd The cmd of the input to the bot.
     * @return The String that the bot should send in response.
     */
    public static String invalidCmd(String cmd) {
        return "Sorry, but I don't know the command \""
                + cmd + "\"" + '\n';
    }

    /**
     * Handles the logic of a single command passed to the bot.
     *
     * @param inp The full line of input to the bot.
     * @return The String that the bot should send in response.
     */
    public static String cmd(String inp) {
        String[] splitInps = inp.strip().split(" ");
        String cmd = splitInps[0].toLowerCase();

        switch (cmd) {
        // Creating Todos ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        case "todo":
            return cmdTodo(inp);
        case "deadline":
            return cmdDeadline(inp);
        case "event":
            return cmdEvent(inp);

        // Modifying Todos ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        case "mark":
            return cmdMark(inp);
        case "unmark":
            return cmdUnmark(inp);
        case "edit":
            return cmdEdit(inp);
        case "delete":
            return cmdDelete(inp);

        // Listing Todos ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        case "list":
            return cmdList(inp);
        case "find":
            return cmdFind(inp);

        // Bai~ and Misc ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        case "bye":
            return cmdBye(inp);
        default:   // Not an existing command
            return invalidCmd(cmd);
        }
    }
}
