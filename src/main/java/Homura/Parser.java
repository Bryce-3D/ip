// How to use and create packages inspired by
// https://github.com/weiseng18/ip/tree/master/src/main/java/panorama
// and
// https://www.w3schools.com/java/java_packages.asp
package Homura;

public class Parser {
    public static Todo parseTodoInp(String inp) {
        inp = inp.strip();
        if (inp.length() <= 5) {
            throw new EmptyInputHomuraException("todo", inp);
        }
        inp = inp.substring(5);   // Remove the "todo " in front
        return new Todo(inp);
    }
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
            throw new InvalidInputHomuraException("event", inp);
        }
    }
    public static Event parseEventInp(String inp) {
        inp = inp.strip();
        if (inp.length() <= 6) {
            throw new EmptyInputHomuraException("Todo", inp);
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
