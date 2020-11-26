import java.util.Scanner;
import java.util.function.Predicate;

public class FindEvensorOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Predicate<Integer> check;
        Predicate<Integer> isOdd;
        int start = scanner.nextInt();
        int end = scanner.nextInt();
        scanner.nextLine();

        String read = scanner.nextLine();
        switch (read) {
            case "even":
                check = n -> n % 2 == 0;
                break;
            case "odd":
                check = n -> n % 2 != 0;
                break;
            default:
                throw new IllegalStateException("Invalid Command");
        }

        for (int i = start; i <= end; i++) {
            if (check.test(i)) {
                System.out.print(i +" ");
            }
        }
    }
}
