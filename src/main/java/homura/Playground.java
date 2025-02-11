// For testing code without using I Run Code Discord Bot
// esp cause I can't fit all my classes in 2k chars
package homura;


import javafx.concurrent.Task;

import java.util.*;
import java.util.stream.Stream;

public class Playground {
    public static void main(String[] args) {
        String s = "what did they \r\nmean by this chat \npls work";
        Stream<String> asdf = s.lines();
        ArrayList<String> qwer = new ArrayList<String>();
        asdf.forEach(qwer::add);
        HomuraUtils.printArrList(qwer);
        for (String q : qwer) {
            System.out.println(q.length());
        }

        String[] ss = {"Mado", "Homu"};
        for (String v : ss) {
            System.out.println(v);
        }
    }
}
