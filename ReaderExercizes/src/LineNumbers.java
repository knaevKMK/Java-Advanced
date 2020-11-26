import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class LineNumbers {
    public static void main(String[] args) throws IOException {
        String pathRead = "inputLineNumbers.txt";
        String pathSave = "output.txt";

        BufferedReader read = new BufferedReader(new FileReader(pathRead));
        PrintWriter out = new PrintWriter(pathSave);
        int n = 1;
        String line = read.readLine();
        while (line != null) {
            out.println(n++ + ". " + line);
            line = read.readLine();
        }
        out.close();
    }
}
