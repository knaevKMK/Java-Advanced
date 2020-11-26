import java.util.ArrayDeque;
import java.util.Scanner;

public class FlowerWreaths {
    private static Scanner scanner = new Scanner(System.in);
    private static int wreath;
    private static int store;

    public static void main(String[] args) {

        ArrayDeque<Integer> roses = new ArrayDeque<>();
        createStack(roses);
        ArrayDeque<Integer> lilies = new ArrayDeque<>();
        createDeque(lilies);

        while (!roses.isEmpty() && !lilies.isEmpty()) {
            int rose = roses.peek();
            int lilie = lilies.peek();
            int sum = rose + lilie;
            switch (sum) {
                case 15:
                    wreath++;
                    roses.pop();
                    lilies.pop();
                    break;
                default:
                    if (sum > 15) {
                        lilies.push(lilies.pop() - 2);
                        continue;
                    }
                    store += roses.pop();
                    store += lilies.pop();
            }

        }
        store /= 15;
        wreath += store;
        String print = "You didn't make it, you need " + (5 - wreath) + " wreaths more!";
        if (wreath >= 5) {
            print = "You made it, you are going to the competition with " + wreath + " wreaths!";
        }
        System.out.println(print);
    }

    private static void createStack(ArrayDeque<Integer> roses) {
        String[] token = scanner.nextLine().split(",\\s+");
        for (String s : token) {
            roses.push(Integer.parseInt(s));
        }
    }

    private static void createDeque(ArrayDeque<Integer> lilies) {
        String[] token = scanner.nextLine().split(",\\s+");
        for (String s : token) {
            lilies.offer(Integer.parseInt(s));
        }
    }
}
