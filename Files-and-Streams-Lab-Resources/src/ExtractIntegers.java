import java.io.*;
import java.nio.file.Path;
import java.util.Scanner;

public class ExtractIntegers {
    public static void main(String[] args) throws FileNotFoundException {
        String inputPat = ("E:/input.txt");
        String outPut = "E:/Extract-Integers.txt";

        Scanner scanner = new Scanner(new FileInputStream((inputPat)));
        PrintWriter out = new PrintWriter(outPut);


        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                out.println(scanner.nextInt());
            }
            scanner.next();
        }
        out.close();

    }
}
