public class Homura {
    public final static String indent = " ".repeat(4);
    public final static String divider = "~".repeat(80) + '\n';

    public static String intro_msg() {
        String ans = indent + divider
            + indent + " Hello! I'm Akemi Homura\n"
            + indent + " What can I do for you?\n"
            + indent + divider
            + indent + " Bye. Hope to see you again soon!\n"
            + indent + divider;
        return ans;
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
    }
}
