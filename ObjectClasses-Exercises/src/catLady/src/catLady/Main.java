package catLady;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Cat> catList = new ArrayList<>();

        String read;
        while (!"End".equals(read=scanner.nextLine())){
            catList.add(new Cat(read.split("\\s+")));
        }
        read=scanner.nextLine();
        for (Cat cat : catList) {
            if (cat.getName().equals(read)){
                System.out.println(cat);
            }
        }
    }
}
