import java.util.Arrays;
import java.util.Scanner;

public class RecursiveArraySum {
    private static int i = 0;
    private static int sum = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        System.out.println(getSum(nums, nums.length));
    }

    private static int getSum(int[] nums,int n) {
        if (n<=0) {
            return 0;
        }
        return (getSum(nums,n-1)+nums[n-1]);
    }
}
