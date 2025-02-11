/**
 * A class for handling storage of the todos.
 */
package homura;

import java.util.ArrayList;

public class Storage {
    public static final String DIVIDER = " | ";

    /**
     * Converts a storage String to a Todo or one of its subclasses.
     *
     * @param s The storage String representation.
     * @return The corresponding Todo, Deadline, or Event.
     */
    public static Todo fromStr(String s) {
        ArrayList<String> ss = HomuraUtils.split(s, DIVIDER);
        switch (ss.get(0)) {
        case "t":
            return Todo.fromStorageStr(s);
        case "d":
            return Deadline.fromStorageStr(s);
        case "e":
            return Event.fromStorageStr(s);
        default:
            return null;
        }
    }
    /**
     * Reads a list of Todos from a file.
     * Returns an empty list if the file does not exist.
     *
     * @param fn The file name being read from.
     * @return The ArrayList of Todos.
     */
    public static TaskList readTodos(String fn) {
        String ftxt = HomuraUtils.readFile(fn);
        if (ftxt == null) {
            return new TaskList();
        }
        ArrayList<String> txts = HomuraUtils.splitLine(ftxt);
        TaskList ans = new TaskList();
        for (String txt : txts) {
            ans.add(fromStr(txt));
        }
        return ans;
    }
    /**
     * Writes a list of Todos to a file.
     * Will overwrite the given file if it already exists.
     *
     * @param tasks The Todos to write.
     * @param fn The filename being written to.
     */
    public static void writeTodos(TaskList tasks, String fn) {
        ArrayList<String> txts = new ArrayList<String>();
        for (Todo t : tasks.getTodos()) {
            txts.add(t.toStorageStr());
        }
        // String concatenation inspired by
        // https://stackoverflow.com/questions/523871/
        // best-way-to-concatenate-list-of-string-objects
        String txt = String.join("\n", txts);
        HomuraUtils.writeFile(txt,fn);
    }
}





// RECYCLING BIN ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
