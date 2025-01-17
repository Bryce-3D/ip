import java.util.*;

public class Homura {
    public final static String indent = " ".repeat(4);
    public final static String divider = "~".repeat(80) + '\n';


    // How to read input referenced from
    // https://github.com/Bryce-3D/My-Codeforces-Codes/blob/main/Java/0001-0100/CF_0001A.java
    private static Scanner sc = new Scanner(System.in);

    public static String intro_msg() {
        return indent + divider
            + indent + " Hi, I'm Akemi Homura.\n"
            + indent + " Have you seem Madoka anywhere?\n"
            + indent + divider;
    }

    public static String bye_msg() {
        return indent + divider
            + indent + " No matter what, don't become a magical girl.\n"
            + indent + " Farewell.\n"
            + indent + divider;
    }

    public static String format_echo(String s) {
        return indent + divider
            + indent + ' ' + s + '\n'
            + indent + divider;
    }

    public static void main(String[] args) {
        System.out.println(intro_msg());
        while (true) {
            // How to read input referenced from
            // https://github.com/Bryce-3D/My-Codeforces-Codes/blob/main/Java/0001-0100/CF_0001A.java
            String inp = sc.nextLine();
            if (inp.equals("bye")) {
                System.out.println(bye_msg());
                break;
            }
            System.out.println(format_echo(inp));
        }
    }
}
