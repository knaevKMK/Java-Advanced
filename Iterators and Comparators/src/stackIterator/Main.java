package stackIterator;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        String read;

        while (!"END".equals(read = scanner.nextLine())) {
            String[] token = read.split("[, ]+");
            switch (token[0]) {
                case "Push":
                    for (int i = 1; i < token.length; i++) {
                        stack.push(Integer.parseInt(token[i]));
                    }
                    break;
                case "Pop":
                    try {
                        stack.pop();
                    } catch (Exception exception) {
                        System.out.println(exception.getMessage());
                    }
                    break;
            }
        }
        for (int i = 0; i < 2; i++) {
            for (Integer integer : stack) {
                System.out.println(integer);
            }

        }
    }
}
