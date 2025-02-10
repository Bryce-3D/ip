// For testing code without using I Run Code Discord Bot
// esp cause I can't fit all my classes in 2k chars

// How to use and create packages inspired by
// https://github.com/weiseng18/ip/tree/master/src/main/java/panorama
// and
// https://www.w3schools.com/java/java_packages.asp
package homura;


import javafx.concurrent.Task;

import java.util.*;

public class Playground {
    public static void main(String[] args) {
        ArrayList<Integer> asdf = new ArrayList<Integer>();
        asdf.add(1);
        asdf.add(2);

        TaskList a = new TaskList();
        a.add(new Todo("a"));
        a.set(0,new Todo("b"));
        System.out.println(a.get(0));

    }
}
