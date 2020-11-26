import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int size = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        System.out.println(Math.abs(diagOne(matrix) - diagTwo(matrix)));

    }

    private static int diagTwo(int[][] matrix) {
        int sum = 0;
        for (int r = 0; r < matrix.length; r++) {
            for (int c = matrix[r].length -r- 1; c >= 0; c--) {
                sum += matrix[r][c];
                break;
            }
        }
        return sum;
    }

    private static int diagOne(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }
}
