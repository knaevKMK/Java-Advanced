import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SumLines {
    public static void main(String[] args) throws IOException {
        String pathReadFile = "input.txt";
        String pathSaveFile = "output.txt";
        BufferedReader read = new BufferedReader(new FileReader(pathReadFile));
        PrintWriter out = new PrintWriter(pathSaveFile);
        String line = read.readLine();
        while (line != null) {
            int values = 0;
            for (int i = 0; i < line.length(); i++) {
                values += line.charAt(i);
            }

            out.println(values);
            line = read.readLine();
        }
        out.close();
    }
}
