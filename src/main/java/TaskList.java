import java.util.ArrayList;

public class TaskList {
    // Attributes + Getters and Setters ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    private ArrayList<Todo> todos;
    public ArrayList<Todo> getTodos() { return todos; }
    public void setTodos(ArrayList<Todo> todos) { this.todos = todos; }



    // Constructors and Factory Methods ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public TaskList() { todos = new ArrayList<Todo>(); }
    public TaskList(ArrayList<Todo> todos) { this.todos = todos; }



    // Functionality copied from ArrayList ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public Todo get(int i) { return todos.get(i); }
    public void add(Todo t) { todos.add(t); }
    public void remove(int i) { todos.remove(i); }
    public int size() { return todos.size(); }



    // Extra functionality ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // None
}
