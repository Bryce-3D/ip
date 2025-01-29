// How to use and create packages inspired by
// https://github.com/weiseng18/ip/tree/master/src/main/java/panorama
// and
// https://www.w3schools.com/java/java_packages.asp
package Homura;

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
