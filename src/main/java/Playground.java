// For testing code without using I Run Code Discord Bot
// esp cause I can't fit all my classes in 2k chars

public class Playground {
    public static void main(String[] args) {
        Todo t = new Todo("Waow");
        Deadline d = new Deadline("stuff","now");
        Event e = new Event("You", "now", "later");

        System.out.println(Storage.to_str(t));
        System.out.println(Storage.to_str(d));
        System.out.println(Storage.to_str(e));

//        System.out.println("Test");
    }
}
