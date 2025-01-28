import java.util.ArrayList;

public class TaskList {
    private static ArrayList<Todo> todos = new ArrayList<Todo>();

    public static ArrayList<Todo> getTodos() { return todos; }
    public static void setTodos(ArrayList<Todo> todos) {
        TaskList.todos = todos;
    }

    // Copy all functionality of ArrayList that I need
    public static Todo get(int i) {
        return todos.get(i);
    }
    public static void add(Todo t) {
        todos.add(t);
    }
    public static void remove(int i) {
        todos.remove(i);
    }
    public static int size() {
        return todos.size();
    }
}
