package frog;

import java.util.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Lake lake = new Lake(Arrays.stream(scanner.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt).toArray());

        String result = "";
        for (Integer integer : lake) {
            result += (integer+", ");
        }
        System.out.println(result.substring(0,result.length()-2));
    }
}
