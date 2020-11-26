import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ALLCAPITALS {
    public static void main(String[] args) throws IOException {
        String pathread = "input.txt";
        String pathSave = "output.txt";

        InputStream read = new FileInputStream(pathread);
        //    BufferedReader read = new BufferedReader(new FileReader(pathread));
        PrintWriter out = new PrintWriter(pathSave);
        byte[] strings = Files.readAllBytes(Path.of(pathread));
        List<String> m = Files.readAllLines(Path.of(pathread));
        // String line = read.readLine();
        //   while (line != null) {
        //     out.println(line.toUpperCase());
        //   line = read.readLine();
        //}
        for (String s : m) {
            System.out.println(s.toUpperCase());
        }

        //       out.close();
    }

}
