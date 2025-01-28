import java.util.ArrayList;

public class TaskList {
    private static ArrayList<Todo> todos = new ArrayList<Todo>();

    public static ArrayList<Todo> getTodos() {
        return todos;
    }
}
