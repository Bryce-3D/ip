import java.util.*;

public class Homura {
    public final static String indent = " ".repeat(4);
    public final static String divider = "~".repeat(80);   // TODO: Add ☆ to this and stuff
    public static ArrayList<String> items = new ArrayList<String>();

    // How to read input inspired by
    // https://github.com/Bryce-3D/My-Codeforces-Codes/blob/main/Java/0001-0100/CF_0001A.java
    private static Scanner sc = new Scanner(System.in);

    public static String intro_msg() {
        return indent + divider + '\n'
            + indent + " Hi, I'm Akemi Homura.\n"
            + indent + " Have you seem Madoka anywhere?\n"
            + indent + divider + '\n';
    }

    public static String bye_msg() {
        return indent + divider + '\n'
            + indent + " No matter what, don't become a magical girl.\n"
            + indent + " Farewell.\n"
            + indent + divider + '\n';
    }

    public static String format_echo(String s) {
        return indent + divider + '\n'
            + indent + ' ' + s + '\n'
            + indent + divider + '\n';
    }

    public static void print_items() {
        ArrayList<String> numbered_items = new ArrayList<String>();
        for (int i = 0; i < items.size(); i++) {
            // Converting int to string representation inspired by
            // https://stackoverflow.com/questions/5071040/java-convert-integer-to-string
            numbered_items.add("" + (i+1) + ".) " + items.get(i));
        }
        for (String item : numbered_items) {
            System.out.println(indent + " " + item);
        }
    }

    public static void print_items_formatted() {
        System.out.println(indent + divider);
        print_items();
        System.out.println(indent + divider + '\n');
    }

    public static void main(String[] args) {
        System.out.println(intro_msg());
        while (true) {
            // How to read input inspired by
            // https://github.com/Bryce-3D/My-Codeforces-Codes/blob/main/Java/0001-0100/CF_0001A.java
            String inp = sc.nextLine();
            if (inp.equals("bye")) {
                System.out.println(bye_msg());
                break;
            } else if (inp.equals("list")) {
                print_items_formatted();
            } else {
                items.add(inp);
                System.out.println((format_echo(inp)));
            }
        }

        // Testing
//        items.add("asdf");
//        items.add("asdfdd");
//        items.add("asdffdfd");
//        items.add("asdffdsa");
//        items.add("asdfasdfasdf");
//        print_items_formatted();
    }
}

// RECYCLING BIN
// String concatenation inspired by
// https://stackoverflow.com/questions/523871/best-way-to-concatenate-list-of-string-objects
