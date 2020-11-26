import java.util.*;
import java.util.function.Predicate;

public class ListOfPredicates {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = Integer.parseInt(scanner.nextLine());
        List<Predicate<Integer>> checkList = new ArrayList<>();

        int[] forList = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        for (int e : forList) {
            checkList.add(integer -> integer % e == 0);
        }


        for (int i = 1; i <= n; i++) {
            if (check(i, checkList)) {
                System.out.print(i + " ");
            }
        }
    }

    private static boolean check(int i, List<Predicate<Integer>> checkList) {
        for (Predicate<Integer> predicate : checkList) {
            if (!predicate.test(i)) {
                return false;
            }
        }
        return true;
    }
}
