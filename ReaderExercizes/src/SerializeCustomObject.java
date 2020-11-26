import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class SerializeCustomObject {
    public static void main(String[] args) throws IOException {
        String pathFile = "C:\\Users\\MASTER\\Desktop\\GitHub\\ReaderExercizes\\Exercises Resources\\ExercisesResources.zip";
        ZipInputStream in = new ZipInputStream(new FileInputStream(pathFile));
        byte[] bytes = in.readAllBytes();
        FileOutputStream out = new FileOutputStream("E/zapis");
        for (byte aByte : bytes) {
            out.write(aByte);
        }
        out.close();
    }
}
