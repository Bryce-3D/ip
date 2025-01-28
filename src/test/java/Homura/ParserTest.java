package Homura;

// Copied from and inspired by
// https://se-education.org/guides/tutorials/junit.html#adding-junit-support-to-your-project
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class ParserTest {
    // Normal Inputs ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    @Test
    public void parseTodoInp_normal1_success() {
        Todo t0 = Parser.parseTodoInp("todo find Kaname Madoka");
        Todo t1 = new Todo("find Kaname Madoka");
        assertEquals(t0,t1);
    }

    @Test
    public void parseDeadlineInp_normal1_success() {
        Deadline d0 = Parser.parseDeadlineInp(
                "deadline Meguca /by 2025-12-31"
        );
        Deadline d1 = new Deadline(
                "Meguca", "2025-12-31"
        );
        assertEquals(d0,d1);
    }

    @Test
    public void parseEventInp_normal1_success() {
        Event e0 = Parser.parseEventInp(
                "event suffering /from 0001-01-01 /to 9999-12-31"
        );
        Event e1 = new Event("suffering",
                "0001-01-01", "9999-12-31"
        );
        assertEquals(e0,e1);
    }

    @Test
    public void parseTodoInp_blank_empInpHomExc() {
        try {
            Parser.parseTodoInp("todo");
            fail();
        } catch (Exception e) {
            EmptyInputHomuraException e0
                    = new EmptyInputHomuraException("todo", "todo");
            assertEquals(e,e0);
        }
    }

    @Test
    public void parseDeadlineInp_blank_empInpHomExc() {
        try {
            Parser.parseDeadlineInp("deadline");
            fail();
        } catch (Exception e) {
            EmptyInputHomuraException e0
                    = new EmptyInputHomuraException("deadline", "deadline");
            assertEquals(e,e0);
        }
    }

    @Test
    public void parseEventInp_blank_empInpHomExc() {
        try {
            Parser.parseEventInp("event");
            fail();
        } catch (Exception e) {
            EmptyInputHomuraException e0
                    = new EmptyInputHomuraException("event", "event");
            assertEquals(e,e0);
        }
    }
}
