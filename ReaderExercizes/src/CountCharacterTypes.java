import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class CountCharacterTypes {
    public static void main(String[] args) throws IOException {
        String pathFile = "input.txt";
        String pathSave = "output.txt";

        BufferedReader read = new BufferedReader(new FileReader(pathFile));
        PrintWriter out = new PrintWriter(pathSave);

        String line = read.readLine();
        int vowels = 0;
        int consonants = 0;
        int punctuation = 0;
        while (line != null) {
            for (int i = 0; i < line.length(); i++) {
                switch (line.charAt(i)) {//•	a, e, i, o, u   !,.?
                    case 'a':
                    case 'e':
                    case 'i':
                    case 'o':
                    case 'u':
                        vowels++;
                        break;
                    case '!':
                    case ',':
                    case '.':
                    case '?':
                        punctuation++;
                        break;
                    case ' ':
                    case '\r':
                    case '\n':
                        break;
                    default:
                        consonants++;
                        break;
                }

            }
            line = read.readLine();
        }
        out.println("Vowels: " + vowels);
        out.println("Consonants: " + consonants);
        out.println("Punctuation: " + punctuation);
        out.close();
    }
}
