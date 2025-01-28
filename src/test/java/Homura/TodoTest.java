package Homura;

// Copied from and inspired by
// https://se-education.org/guides/tutorials/junit.html#adding-junit-support-to-your-project
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class TodoTest {
    // Normal Inputs ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    @Test
    public void fromStorageStr_normalUnmarked_success() {
        String descr = "find Madoka";
        Todo t0 = Todo.fromStorageStr(
                "todo" + Storage.DIVIDER + "0"
                + Storage.DIVIDER + descr
        );
        Todo t1 = new Todo(descr);
        assertEquals(t1,t0);
    }
    @Test
    public void fromStorageStr_normalMarked_success() {
        String descr = "marry Madoka";
        Todo t0 = Todo.fromStorageStr(
                "todo" + Storage.DIVIDER + "1"
                + Storage.DIVIDER + descr
        );
        Todo t1 = new Todo(descr);
        t1.setIsDone(true);
        assertEquals(t1,t0);
    }
    @Test
    public void toStorageStr_normalUnmarked_success() {
        String descr = "survive >20 hrs of CS2103T per week";
        Todo t = new Todo(descr);
        String s0 = t.toStorageStr();
        String s1 = "t" + Storage.DIVIDER + "0"
                + Storage.DIVIDER + descr;
        assertEquals(s1,s0);
    }
    @Test
    public void toStorageStr_normalMarked_success() {
        String descr = "Spend half my time on 4 of 26 units";
        Todo t = new Todo(descr);
        t.setIsDone(true);
        String s0 = t.toStorageStr();
        String s1 = "t" + Storage.DIVIDER + "1"
                + Storage.DIVIDER + descr;
        assertEquals(s1,s0);
    }



    // Invalid Inputs ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    @Test
    public void fromStorageStr_invalid_die() {
        try {
            Todo.fromStorageStr("chat what did they mean by this");
            fail();
        } catch (Exception e) {
        }
    }
}
