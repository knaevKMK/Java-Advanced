import java.util.ArrayDeque;
import java.util.Scanner;

public class LootBox {

    private static Scanner scanner = new Scanner(System.in);
    private static int claimedSum;

    public static void main(String[] args) {
        ArrayDeque<Integer> first = new ArrayDeque<>();
        createQue(first);
        ArrayDeque<Integer> second = new ArrayDeque<>();
        creatStack(second);

        while (true) {
            int one = first.pop();
            int two = second.pop();
            int sum = one + two;

            if (sum % 2 == 0) {
                claimedSum += sum;


            } else {
                first.push(one);
                first.offer(two);
            }
            if (first.isEmpty()) {
                print("First lootbox is empty");
                break;
            }
            if (second.isEmpty()) {
                print("Second lootbox is empty");
                break;
            }
        }
        if (claimedSum >= 100) {
            print("Your loot was epic! Value: " + claimedSum);
        } else {
            print("Your loot was poor... Value: " + claimedSum);
        }

    }

    private static void print(String s) {
        System.out.println(s);
    }

    private static void createQue(ArrayDeque<Integer> first) {
        String[] token = scanner.nextLine().split("\\s+");
        for (String s : token) {
            first.offer(Integer.parseInt(s));
        }
    }

    private static void creatStack(ArrayDeque<Integer> second) {
        String[] token = scanner.nextLine().split(" ");
        for (String s : token) {
            second.push(Integer.parseInt(s));
        }
    }
}