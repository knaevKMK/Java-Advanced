import java.util.ArrayDeque;
import java.util.Scanner;

public class Scheduling {
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayDeque<Integer> exercizes = new ArrayDeque<>();
    private static ArrayDeque<Integer> values = new ArrayDeque<>();
    private static int kill;


    public static void main(String[] args) {
        load();
        run();
        printList(values);
    }

    private static void printList(ArrayDeque<Integer> list) {
        if (list.isEmpty()) {
            return;
        }
        while (!list.isEmpty()) {
            System.out.print(list.pop() + " ");
        }
        System.out.println();
    }

    private static void run() {
        while (!exercizes.isEmpty() && !values.isEmpty()) {
            int exerciz = exercizes.peek();
            int thread = values.peek();
            if (exerciz == kill) {
                System.out.println("Thread with value " + thread + " killed task " + kill);
                return;
            }
            if (thread >= exerciz) {
                exercizes.pop();
                values.pop();
            } else {
                values.pop();
            }


        }
    }

    private static void load() {
        String[] token = scanner.nextLine().split(",\\s+");
        for (String s : token) {
            exercizes.push(Integer.parseInt(s));
        }
        token = scanner.nextLine().split("\\s+");
        for (String s : token) {
            values.offer(Integer.parseInt(s));
        }
        kill = Integer.parseInt(scanner.nextLine());
    }
}
