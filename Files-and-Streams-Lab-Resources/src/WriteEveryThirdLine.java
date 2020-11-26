import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {
        String pathFile = "input.txt";
        BufferedReader read = new BufferedReader(new FileReader(pathFile));
        PrintWriter out = new PrintWriter("out.txt");
        int count = 0;
        String line = read.readLine();
        while (line != null) {
            count++;
            if (count % 3 == 0) {
                out.println(line);
            }
            line = read.readLine();
        }
        out.close();
    }
}
