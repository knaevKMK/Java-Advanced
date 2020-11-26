import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayDeque;

public class NestedFolders {
    static PrintWriter out;

    static {
        try {
            out = new PrintWriter("dirs.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    static ArrayDeque<File> list = new ArrayDeque<>();
    static int count = 0;

    public static void main(String[] args) throws FileNotFoundException {
        String path = "Files-and-Streams";
        File directories = new File(path);
        if (directories.isDirectory()) {
            count++;
            out.println(directories.getName());
        }
        for (File file : directories.listFiles()) {
            if (file.isDirectory()) {
                count++;
                out.println(file.getName());
                checkDir(file);
            }
        }
        out.println("[" + count + "] folders");
        out.close();
    }

    private static void checkDir(File file) {
        for (File listFile : file.listFiles()) {
            if (listFile.isDirectory()) {
                count++;
                out.println(listFile.getName());
                checkDir(listFile);
            }
        }
    }
}
