public class Homura {
    public final static String indent = " ".repeat(4);
    public final static String divider = "~".repeat(80) + '\n';
    
    public static String format_echo(String s) {
        String ans = indent + divider
            + indent + s + '\n'
            + indent + divider
            + '\n';
        return ans;
    }

    public static void main(String[] args) {
        String msg = divider
                + " Hello! I'm Akemi Homura\n"
                + " What can I do for you?\n"
                + divider
                + " Bye. Hope to see you again soon!\n"
                + divider;
        System.out.println(msg);
    }
}
