import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Storage {
    /**
     * Returns the contents of a file as a String.
     * Returns null if the file does not exist.
     *
     * @param fn The filename.
     * @return The file contents or null.
     */
    public static String read_file(String fn) {
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
     * @param fn The filename.
     * @param txt The text to write.
     */
    public static void write_file(String fn, String txt) {
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
}
