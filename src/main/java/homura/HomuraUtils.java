/**
 * A class for utility helper functions.
 */

// Helper functions

// How to use and create packages inspired by
// https://github.com/weiseng18/ip/tree/master/src/main/java/panorama
// and
// https://www.w3schools.com/java/java_packages.asp
package homura;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class HomuraUtils {
    /**
     * Returns the contents of a file as a String.
     * Returns null if the file does not exist.
     *
     * @param fn The filename.
     * @return The file contents or null.
     */
    public static String readFile(String fn) {
        File f = new File(fn);
        // How to read the contents of a file inspired by
        // https://stackoverflow.com/questions/72361778/
        // how-can-i-get-java-to-read-all-text-in-file
        try {
            Scanner sc = new Scanner(f).useDelimiter("\\A");
            return sc.next();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Writes the String to a file.
     * Creates a file if it does not exist and overwrites an
     * existing file, if any.
     *
     * @param txt The text to write.
     * @param fn The filename.
     */
    public static void writeFile(String txt, String fn) {
        File f = new File(fn);
        try {
            f.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            FileWriter fw = new FileWriter(f);
            fw.write(txt);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Splits a string along a given divider.
     *
     * @param s The string being split.
     * @param div The divider.
     * @return The parts of `s` after being split along `div`.
     */
    public static ArrayList<String> split(String s, String div) {
        String[] ansArr = s.split(Pattern.quote(div));
        ArrayList<String> ans = new ArrayList<String>(Arrays.asList(ansArr));
        return ans;
    }

    /**
     * Prints an ArrayList in a readable format.
     *
     * @param a The ArrayList to print.
     */
    public static void printArrList(ArrayList<? extends Object> a) {
        for (Object o : a) {
            System.out.println(o);
        }
    }
}





// RECYCLING BIN ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
