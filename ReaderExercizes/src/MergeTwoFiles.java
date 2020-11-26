import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class MergeTwoFiles {
    public static void main(String[] args) throws IOException {
        String[] files = {"inputOne.txt", "inputTwo.txt"};
        BufferedReader read;
        PrintWriter out = new PrintWriter("merge.txt");
        for (String file : files) {
            read = new BufferedReader(new FileReader(file));
            String line = read.readLine();
            while (line != null) {
                out.println(line);
                line = read.readLine();
            }
        }
        out.close();
    }
}
