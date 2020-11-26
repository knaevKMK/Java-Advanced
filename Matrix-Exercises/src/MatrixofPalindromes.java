import java.util.Arrays;
import java.util.Scanner;

public class MatrixofPalindromes {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[][] matrix = getMatrix();
        printMatrix(matrix);
    }

    private static String[][] getMatrix() {
        int[] sizes = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        String[][] matrix = new String[sizes[0]][sizes[1]];
        for (int i = 0; i < sizes[0]; i++) {
            for (int j = 0; j < sizes[1]; j++) {
                matrix[i][j] = "" + (char) ('a' + i) +(char) ('a' + i + j) +(char) ('a' + i);
            }
        }
        return matrix;
    }

    private static void printMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
