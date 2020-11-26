import java.io.*;
import java.nio.file.Path;
import java.util.Arrays;

public class GetFolderSize {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\MASTER\\Desktop\\GitHub\\ReaderExercizes\\Exercises Resources";
        File directorie = new File(path);
        int sum = 0;
         for (File file : directorie.listFiles()) {
            sum += file.length();
        }
        PrintWriter out = new PrintWriter("output.txt");
        out.print("Folder size: " + sum);
        out.close();
    }
}
