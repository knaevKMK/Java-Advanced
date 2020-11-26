import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class CountUppercaseWords {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        Predicate<String> isUpperFirstChar = s -> Character.isUpperCase(s.charAt(0));
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String[] text = read.readLine().split("\\s+");

        List<String> result = new ArrayList<>();
        for (String s : text) {
            if (isUpperFirstChar.test(s)) {
                result.add(s);
            }
        }
        System.out.println(result.size());
        result.forEach(System.out::println);
    }
}
