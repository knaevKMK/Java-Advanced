import java.io.*;
import java.nio.file.Files;
import java.util.Scanner;


public class CopyBytes {
    public static void main(String[] args) throws IOException {
        FileReader file = new FileReader("E:\\input.txt");
        FileWriter save = new FileWriter("E:\\Copy-Bytes.txt");
        int oneByte = 0;
        while ((oneByte = file.read()) >= 0) {
            if (oneByte == 10 || oneByte == 32) {
                save.write(oneByte);
            } else {
                String add = String.valueOf(oneByte);
                for (int i = 0; i < add.length(); i++) {
                    save.write(add.charAt(i));
                }
            }
        }
        save.close();
    }
}
