// For testing code without using I Run Code Discord Bot
// esp cause I can't fit all my classes in 2k chars
package homura;


import javafx.concurrent.Task;

import java.util.*;

public class Playground {
    public static void main(String[] args) {
        String s0 = "d | 0 | CS2103T | 2025-02-28";
        String s1 = "d | 0 | you | 2010-01-01";
        Deadline d0 = (Deadline) Storage.fromStr(s0);
        Deadline d1 = (Deadline) Storage.fromStr(s1);
    }
}
