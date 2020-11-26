import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class ListFiles {
    public static void main(String[] args) throws IOException {
        String pathFile = "Files-and-Streams";
        PrintWriter out = new PrintWriter("check.txt");
        File directorie = new File(pathFile);
        for (File file : directorie.listFiles()) {
            if (file.isDirectory()) {
                continue;
            }
           out.println(file.getName() + ": [" + file.length()+"]");
        }
        out.close();
    }
}
