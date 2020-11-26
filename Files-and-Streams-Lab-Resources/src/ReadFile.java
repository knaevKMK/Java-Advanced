import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ReadFile {

    public static void main(String[] args) throws IOException {
        Path path = Path.of("E:\\input.txt");
        File file = new File(String.valueOf(path));
        //  String path = "E:\input.txt";
        byte[] bytes = Files.readAllBytes(path);
        for (byte oneByte : bytes) {

            //      try (FileInputStream file = new FileInputStream(path)) {
            //        int oneByte = file.read();
            //      while (oneByte >= 0) {
            System.out.print(Integer.toBinaryString(oneByte) + " ");
            //      oneByte = file.read();
            //}
            //     } catch (IOException e) {
            //       e.printStackTrace();
        }
    }
}
