import java.io.*;
import java.util.*;


public class WriteFile {
    public static void main(String[] args) {
        File file = new File("E:/input.txt");

        //    FileInputStream fileInputStream = new FileInputStream(file);
        //   Scanner scanner = new Scanner(fileInputStream);
        Set<Character> exceptions = new HashSet<>(Arrays.asList(',', '.', '!', '?'));

        try (InputStream inputStream = new FileInputStream(file);
             OutputStream outputStream = new FileOutputStream("E:/out.txt")
        ) {
            int oneByte = 0;
            while ((oneByte = inputStream.read()) >= 0) {
                if (exceptions.contains((char) oneByte)) {
                    continue;
                }
                outputStream.write(oneByte);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // StringBuilder text = new StringBuilder();
        //   String line = scanner.nextLine();
        //   while (line != null) {
        //       //       text.append(line.replaceAll("[,\\.!\\?]", ""));
        //       //     text.append("\r\n");
        //       try {
        //           line = scanner.nextLine();
        //       } catch (NoSuchElementException exception) {
        //           fileInputStream.close();
        //       }
        //   }
        //   OutputStream out = new FileOutputStream("E:/out.txt");
        //   PrintWriter outPrint = new PrintWriter(out);
        //   String str = line.toString();
        //   outPrint.print(str);

    }
}
