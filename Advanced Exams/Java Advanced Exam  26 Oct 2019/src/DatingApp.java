import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.logging.Level;

public class DatingApp {
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayDeque<Integer> males = new ArrayDeque<>();
    private static ArrayDeque<Integer> females = new ArrayDeque<>();
    private static int match;

    public static void main(String[] args) {
        load();
        run();
        result();


    }

    private static void result() {
        System.out.println("Matches: " + match);
        printList("Males left: ", males);
        printList("Females left: ", females);
    }

    private static void printList(String s, ArrayDeque<Integer> list) {
        StringBuilder print = new StringBuilder(s);
        if (list.isEmpty()) {
            print.append("none");
        } else {
            while (!list.isEmpty()) {
                print.append(list.pop()).append(", ");
            }
            print.delete(print.lastIndexOf(","), print.length());
        }
        System.out.println(print);
    }

    private static void run() {
        while (!males.isEmpty() && !females.isEmpty()) {
            int male = males.pop();
            int female = females.poll();
            if (male * female <= 0) {
                if (male > 0) {
                    males.push(male);
                }
                if (female > 0) {
                    females.push(female);
                }
                continue;
            }
            if (male % 25 == 0 || female % 25 == 00) {
                if (male % 25 == 0) {
                    males.pop();
                } else {
                    males.push(male);
                }
                if (female % 25 == 00) {
                    females.pop();
                } else {
                    females.push(female);
                }
                continue;
            }
            if (male == female) {
                match++;
                continue;
            }
            males.push(male - 2);
        }
    }

    private static void load() {
        String[] token = scanner.nextLine().split("\\s+");
        for (String s : token) {
            males.push(Integer.parseInt(s));
        }

        token = scanner.nextLine().split("\\s+");
        for (String s : token) {
            females.offer(Integer.parseInt(s));
        }

    }
}
