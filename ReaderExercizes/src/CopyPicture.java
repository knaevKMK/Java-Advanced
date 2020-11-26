import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyPicture {
    public static void main(String[] args) throws IOException {
        String pathPic = "E:/id pc.jpg";
        String saveFile = "E:/id pc-copy.jpg";
        FileInputStream read = new FileInputStream(pathPic);
        FileOutputStream print = new FileOutputStream(saveFile);
        byte[] bytes = read.readAllBytes();
        for (byte aByte : bytes) {
            print.write(aByte);
        }

    }
}
