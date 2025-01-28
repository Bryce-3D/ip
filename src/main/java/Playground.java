// For testing code without using I Run Code Discord Bot
// esp cause I can't fit all my classes in 2k chars

import java.util.*;

public class Playground {
    public static void main(String[] args) {
        // How to initialize ArrayList with values inspired by
        // https://stackoverflow.com/questions/1005073/
        // initialization-of-an-arraylist-in-one-line
        ArrayList<Integer> aa = new ArrayList<Integer>(
                Arrays.asList(1,2,3)
        );
        ArrayList<Integer> a = L.getA();
        a = aa;

        for (int i : L.getA()) {
            System.out.println(i);
        }
    }
}

// From testing
// I can't seem just modify it
// change a's reference -> does not change L.a's reference, need like
// pointers or references from C++ or something
// mafan sia

// How to declare multiple classes in a single file inspired by
// https://stackoverflow.com/questions/2336692/
// java-multiple-class-declarations-in-one-file
class L {
    private static ArrayList<Integer> a = new ArrayList<Integer>();
    public static ArrayList<Integer> getA() { return a; }
    // public static
}












//        Todo t = new Todo("Waow");
//        Deadline d = new Deadline("stuff","now");
//        Event e = new Event("You", "now", "later");
//
//        ArrayList<Todo> a = new ArrayList<Todo>();
//        a.add(t); a.add(d); a.add(e);
//
//        String fn = "Test2.txt";
//        Storage.writeTodos(a,fn);
//        ArrayList<Todo> a0 = Storage.readTodos(fn);
//        HomuraUtils.printArrList(a0);








//        ArrayList<String> a = new ArrayList<String>();
//        a.add("a");
//        a.add("b");
//        a.add("c");
//        HomuraUtils.printArrList(a);








//        Todo t = new Todo("Waow");
//        Deadline d = new Deadline("stuff","now");
//        Event e = new Event("You", "now", "later");
//
//        String ts = Storage.to_str(t);
//        String ds = Storage.to_str(d);
//        String es = Storage.to_str(e);
//
//        Todo t0 = Storage.from_str(ts);
//        Deadline d0 = (Deadline) Storage.from_str(ds);
//        Event e0 = (Event) Storage.from_str(es);
//
//        System.out.println(ts);
//        System.out.println(ds);
//        System.out.println(es);
//
//        System.out.println(t0);
//        System.out.println(d0);
//        System.out.println(e0);
//
//        t.setIsDone(true);
//        d.setIsDone(true);
//        e.setIsDone(true);
//
//        ts = Storage.to_str(t);
//        ds = Storage.to_str(d);
//        es = Storage.to_str(e);
//
//        t0 = Storage.from_str(ts);
//        d0 = (Deadline) Storage.from_str(ds);
//        e0 = (Event) Storage.from_str(es);
//
//        System.out.println(t0);
//        System.out.println(d0);
//        System.out.println(e0);






//        String s0 = "Wait | what | ???";
//        ArrayList<String> ss = HomuraUtils.split(s0," | ");
//        for (String s : ss) {
//            System.out.println(s);
//        }





//        String s0 = "Wait | what | ???";
//        String[] ss = s0.split(" | ");
//        for (String s : ss) {
//            System.out.println(s);
//        }
//        System.out.println(ss.length);   // 5?
//        // https://stackoverflow.com/questions/4731055/whitespace-matching-regex-java


//        System.out.println("Test");
