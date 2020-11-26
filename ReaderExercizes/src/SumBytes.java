import java.io.*;

public class SumBytes {
    public static void main(String[] args) throws IOException {
        String pathRead = "input.txt";
        String pathSave = "output.txt";

        BufferedReader read = new BufferedReader(new FileReader(pathRead));
        PrintWriter out = new PrintWriter(pathSave);

        String line = read.readLine();
        long sum = 0;
        while (line != null) {
            for (int i = 0; i < line.length(); i++) {
                sum += line.charAt(i);
            }
            line = read.readLine();
        }
        out.print(sum);
        out.close();
    }
}
