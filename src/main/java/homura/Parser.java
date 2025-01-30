/**
 * A class for parsing.
 */

// How to use and create packages inspired by
// https://github.com/weiseng18/ip/tree/master/src/main/java/panorama
// and
// https://www.w3schools.com/java/java_packages.asp
package homura;

public class Parser {
    /**
     * Parses a Todo command from the user.
     *
     * @param inp The user's full input.
     * @return The created Todo object.
     */
    public static Todo parseTodoInp(String inp) {
        inp = inp.strip();
        if (inp.length() <= 5) {
            throw new EmptyInputHomuraException("todo", inp);
        }
        inp = inp.substring(5);   // Remove the "todo " in front
        return new Todo(inp);
    }
    /**
     * Parses a Deadline command from the user.
     *
     * @param inp The user's full input.
     * @return The created Deadline object.
     */
    public static Deadline parseDeadlineInp(String inp) {
        inp = inp.strip();
        if (inp.length() <= 9) {
            throw new EmptyInputHomuraException("deadline", inp);
        }
        try {
            inp = inp.substring(9);   // Remove the "deadline " in front
            String[] splitInps = inp.split(" /by ");
            String descr = splitInps[0];
            String byStr = splitInps[1];
            return new Deadline(descr,byStr);
        } catch (Exception e) {
            throw new InvalidInputHomuraException("deadline", inp);
        }
    }
    /**
     * Parses an Event command from the user.
     *
     * @param inp The user's full input.
     * @return The created Event object.
     */
    public static Event parseEventInp(String inp) {
        inp = inp.strip();
        if (inp.length() <= 6) {
            throw new EmptyInputHomuraException("event", inp);
        }
        try {
            inp = inp.substring(6);   // Remove the "event " in front
            String[] splitInps = inp.split(" /from ");
            String descr = splitInps[0];
            splitInps = splitInps[1].split(" /to ");
            String sta = splitInps[0];
            String end = splitInps[1];
            return new Event(descr, sta, end);
        } catch (Exception e) {
            throw new InvalidInputHomuraException("event", inp);
        }
    }
}
