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
        Deadline d = new Deadline("asdf", "2025-01-01");
        d.edit("/des", "qwer");
        d.edit("/by","2024-01-01");
        System.out.println(d);

        Event e = new Event("asdf",
                "2025-01-01", "2024-12-31");
        e.edit("/des", "qewr");
        e.edit("/from","2024-01-31");
        e.edit("/to","2025-12-31");
        System.out.println(e);


        Todo t = new Todo("asdf");
        t.edit("/by", "HomuraRuntimeException");

        System.exit(0);


//        Todo t = new Todo("asdf");
//        t.edit("/des","fdsa");
//        System.out.println(t);
//        System.exit(0);

        System.out.println(new A() instanceof Object);
        System.out.println(new B() instanceof A);

        A a = new A();
        A b = new B();
        System.out.println(a.getClass().getSimpleName());   // A
        System.out.println(b.getClass().getSimpleName());   // B
    }
}

class A {}

class B extends A {}
