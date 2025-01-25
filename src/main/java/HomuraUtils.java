// Helper functions

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

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
        // https://stackoverflow.com/questions/72361778/how-can-i-get-java-to-read-all-text-in-file
        try {
            Scanner sc = new Scanner(f).useDelimiter("\\A");
            return sc.next();
        } catch (FileNotFoundException e) {
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
        }
        try {
            FileWriter fw = new FileWriter(f);
            fw.write(txt);
            fw.close();
        } catch (IOException e) {
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
        // Indices where `div` appears in `s`
        ArrayList<Integer> inds = new ArrayList<Integer>();
        int l_s = s.length();
        int l_d = div.length();

        // Linearly scan `s` to find instances of `div`
        int ind = 0;
        while (ind < l_s-l_d) {
            if (s.substring(ind,ind+l_d).equals(div)) {
                inds.add(ind);
                ind += l_d;
            } else{
                ind += 1;
            }
        }

        // Extract the relevant substrings from `s`
        ArrayList<String> ans = new ArrayList<String>();
        ind = 0;
        for (int i = 0; i < inds.size(); i++) {
            ans.add(s.substring(ind,inds.get(i)));
            ind = inds.get(i) + l_d;
        }
        // Don't forget the part after the last `div`, if any
        if (ind < l_s) {
            ans.add(s.substring(ind));
        }
        return ans;
    }
}
