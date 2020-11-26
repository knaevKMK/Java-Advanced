import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordCount {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new FileReader("words.txt"));

        Map<String, Integer> list = new HashMap<>();
        getMap(scanner.nextLine().split("\\s+"), list);

        BufferedReader read = new BufferedReader(new FileReader("text.txt"));

        String line = read.readLine();

        while (line != null) {
            String[] token = line.split(",?\\s+");
            for (String s : token) {
                if (list.containsKey(s)) {
                    list.put(s, list.get(s) + 1);
                }
            }
            line = read.readLine();
        }
        String pathSave = "results.txt";
        PrintWriter out = new PrintWriter(pathSave);

        list.entrySet().stream()
                .sorted((f, s) -> Integer.compare(s.getValue(), f.getValue()))
                .forEach(e -> out.println(e.getKey() + " - " + e.getValue()));
        out.close();

    }

    private static void getMap(String[] split, Map<String, Integer> list) {
        for (String s : split) {
            list.put(s, 0);
        }
    }
}
