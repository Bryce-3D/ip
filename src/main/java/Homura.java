import java.util.*;

public class Homura {
    public final static String indent = " ".repeat(4);
    public final static String divider = "~".repeat(80) + '\n';


    // How to read input referenced from
    // https://github.com/Bryce-3D/My-Codeforces-Codes/blob/main/Java/0001-0100/CF_0001A.java
    private static Scanner sc = new Scanner(System.in);

    public static String intro_msg() {
        String ans = indent + divider
            + indent + " Hello! I'm Akemi Homura\n"
            + indent + " What can I do for you?\n"
            + indent + divider
            + indent + " Bye. Hope to see you again soon!\n"
            + indent + divider;
        return ans;
    }

    public static String bye_msg() {
        return "TODO";
    }

    public static String format_echo(String s) {
        String ans = indent + divider
            + indent + s + '\n'
            + indent + divider
            + '\n';
        return ans;
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
