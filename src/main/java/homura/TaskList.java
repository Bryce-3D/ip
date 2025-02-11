/**
 * A class for representing an ArrayList of Todos
 */
package homura;

import java.util.ArrayList;

public class TaskList {
    // Attributes + Getters and Setters ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    private ArrayList<Todo> todos;
    public ArrayList<Todo> getTodos() {
        return todos;
    }
    public void setTodos(ArrayList<Todo> todos) {
        this.todos = todos;
    }



    // Constructors and Factory Methods ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public TaskList() {
        todos = new ArrayList<Todo>();
    }
    public TaskList(ArrayList<Todo> todos) {
        this.todos = todos;
    }



    // Functionality copied from ArrayList ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    /**
     * Gets the ith todo.
     *
     * @param i The index being retrieved.
     * @return The ith todo.
     */
    public Todo get(int i) {
        return todos.get(i);
    }
    public void set(int i, Todo t) {
        todos.set(i,t);
    }
    /**
     * Adds a todo to the ArrayList.
     *
     * @param t The todo to add.
     */
    public void add(Todo t) {
        todos.add(t);
    }
    /**
     * Removes the ith todo.
     *
     * @param i The index being removed.
     */
    public void remove(int i) {
        todos.remove(i);
    }
    /**
     * Returns the size of the todo ArrayList.
     *
     * @return The size of the todo ArrayList.
     */
    public int size() {
        return todos.size();
    }



    // Extra functionality ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    /**
     * Finds all todos that contain s in its description.
     *
     * @param s The string to lookup.
     * @return An ArrayList of all todos with s in its description.
     */
    public ArrayList<Todo> findTodosWith(String s) {
        ArrayList<Todo> ans = new ArrayList<Todo>();
        for (Todo t : todos) {
            if (t.contains(s)) {
                ans.add(t);
            }
        }
        return ans;
    }
}
