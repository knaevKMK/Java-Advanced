import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

public class SortLines {
    public static void main(String[] args) throws IOException {
        String pathFile = "input.txt";
        BufferedReader read = new BufferedReader(new FileReader(pathFile));
        List<String> lines = Files.readAllLines(Path.of(pathFile));
        PrintWriter out = new PrintWriter("sort.txt");
        lines.sort(String::compareTo);
        for (String line : lines) {
            out.println(line);
        }
        out.close();
    }
}
