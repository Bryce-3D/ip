/**
 * A class for the main logic of the chatbot Homura.
 */

// How to use and create packages inspired by
// https://github.com/weiseng18/ip/tree/master/src/main/java/panorama
// and
// https://www.w3schools.com/java/java_packages.asp
package homura;

import java.util.ArrayList;
import java.util.Scanner;

public class Homura {
    // Attributes + Getters and Setters ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public final static String INDENT = " ".repeat(4);
    public final static String TODOS_FILENAME = "HomuraTodos.txt";

    private static TaskList todos = new TaskList();

    public static TaskList getTodos() { return todos; }
    public static void setTodos(TaskList todos) { Homura.todos = todos; }



    // Bot Messages ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // Moved to Ui.java now

    // Bot on/off logic ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // Deprecated due to removal of CLI support

    // Bot commands logic ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // Deprecated due to removal of CLI support



    // Bot commands logic (JavaFX) ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    /**
     * Handles the logic of the todo command.
     *
     * @param inp The full line of input to the bot.
     */
    public static String cmdTodoJavafx(String inp) {
        Todo t = Parser.parseTodoInp(inp);
        todos.add(t);
        return t.addStrJavafx();
    }
    /**
     * Handles the logic of the deadline command.
     *
     * @param inp The full line of input to the bot.
     */
    public static String cmdDeadlineJavafx(String inp) {
        Deadline d = Parser.parseDeadlineInp(inp);
        todos.add(d);
        return d.addStrJavafx();
    }
    /**
     * Handles the logic of the event command.
     *
     * @param inp The full line of input to the bot.
     */
    public static String cmdEventJavafx(String inp) {
        Event e = Parser.parseEventInp(inp);
        todos.add(e);
        return e.addStrJavafx();
    }

    /**
     * Handles the logic of the mark command.
     *
     * @param inp The full line of input to the bot.
     */
    public static String cmdMarkJavafx(String inp) {
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
     */
    public static String cmdUnmarkJavafx(String inp) {
        String[] splitInps = inp.split(" ");
        int i = Integer.parseInt(splitInps[1]) - 1;
        todos.get(i).setIsDone(false);
        return todos.get(i).unmarkStrJavafx();
    }
    /**
     * Handles the logic of the delete command.
     *
     * @param inp The full line of input to the bot.
     */
    public static String cmdDeleteJavafx(String inp) {
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

    public static String cmdListJavafx(String inp) {
        return Ui.todosFormattedJavafx();
    }
    /**
     * Handles the logic of the find command.
     *
     * @param inp The full line of input to the bot.
     */
    public static String cmdFindJavafx(String inp) {
        String[] splitInps = inp.split(" ");
        String s= splitInps[1];
        ArrayList<Todo> matches = todos.findTodosWith(s);
        return Ui.foundTodosFormattedJavafx(matches);
    }

    public static String cmdByeJavafx(String inp) {
        Storage.writeTodos(todos, TODOS_FILENAME);
        return Ui.byeMsgJavafx();
    }
    
    public static String cmdJavafx(String inp) {
        String[] splitInps = inp.split(" ");
        String cmd = splitInps[0].toLowerCase();

        switch (cmd) {
        case "bye":   // Say goodbye to Homura
            return cmdByeJavafx(inp);
        case "list":
            return cmdListJavafx(inp);
        case "mark":   // Mark a Todo on the list
            return cmdMarkJavafx(inp);
        case "unmark":   // Unmark a Todo on the list
            return cmdUnmarkJavafx(inp);
        case "todo":   // Add a Todo to the list
            return cmdTodoJavafx(inp);
        case "deadline":   // Add a deadline to the list
            return cmdDeadlineJavafx(inp);
        case "event":   // Add an event to the list
            return cmdEventJavafx(inp);
        case "delete":   // Remove an event from the list
            return cmdDeleteJavafx(inp);
        case "find":   // Find todos in the list with some text
            return cmdFindJavafx(inp);
        default:   // Not a command
            throw new InvalidCmdHomuraException(cmd);
        }
    }



    // Main ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // Deprecated due to removal of CLI support
}





// RECYCLING BIN ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// String concatenation inspired by
// https://stackoverflow.com/questions/523871/
// best-way-to-concatenate-list-of-string-objects
