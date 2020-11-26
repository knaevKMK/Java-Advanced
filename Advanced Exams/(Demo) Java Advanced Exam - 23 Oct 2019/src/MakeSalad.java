import java.util.ArrayDeque;
import java.util.Scanner;

public class MakeSalad {
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayDeque<String> vegetable = new ArrayDeque<>();
    private static ArrayDeque<Integer> calories = new ArrayDeque<>();
    private static ArrayDeque<Integer> salads = new ArrayDeque<>();


    public static void main(String[] args) {
        load();
        run();
        print(salads);
        printS(vegetable);
        print(calories);
    }

    private static void printS(ArrayDeque<String> list) {
        if (!list.isEmpty()) {
            System.out.println(list.toString().replaceAll("[\\[\\],]", ""));
        }
    }

    private static void print(ArrayDeque<Integer> list) {
        if (!list.isEmpty()) {
            System.out.println(list.toString().replaceAll("[\\[\\],]", ""));
        }
    }

    private static void run() {

        while (!vegetable.isEmpty() && !calories.isEmpty()) {

            int salad = calories.peek();
            while (salad > 0 && !vegetable.isEmpty()) {
                salad -= getValue(vegetable.pop());
            }
            salads.offer(calories.pop());
        }


    }

    private static int getValue(String pop) {
        switch (pop) {
            case "tomato":
                return (80);
            case "carrot":
                return ((136));
            case "lettuce":
                return (109);
            case "potato":
                return (215);
            default:
                return 0;
        }
    }

    private static void load() {
        String[] read = scanner.nextLine().split(" ");
        for (String s : read) {
            vegetable.offer(s);
        }
        read = scanner.nextLine().split(" ");
        for (String s : read) {
            calories.push(Integer.parseInt(s));

        }
    }
}
