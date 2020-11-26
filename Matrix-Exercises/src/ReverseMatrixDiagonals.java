import java.util.Arrays;
import java.util.Scanner;

public class ReverseMatrixDiagonals {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int row = scanner.nextInt();
        int col = scanner.nextInt();
        scanner.nextLine();

        int[][] matrix = new int[row][col];
        getMatrix(matrix);

        for (int r = row - 1; r >= 0; r--) {
            if (r < row - 1) {
                goesToDiag(r, matrix);
                System.out.println();
                continue;
            }
            for (int c = col - 1; c >= 0; c--) {
                System.out.print(matrix[r][c] + " ");
                if (c + 1 == col || r - 1 == -1) {
                    System.out.println();
                    continue;
                }
                int k = c + 1;
                for (int i = r - 1; i >= 0; i--) {
                    System.out.print(matrix[i][k++] + " ");
                    if (k == col || i - 1 == -1) {
                        System.out.println();
                        break;
                    }
                }
            }
        }
    }

    private static void goesToDiag(int r, int[][] matrix) {
        int j = 0;
        for (int i = r; i >= 0; i--) {
            System.out.print(matrix[i][j++] + " ");
            if (j == matrix[r].length || r - 1 == -1) {
                j = 0;
                break;
            }
        }
    }


    private static void getMatrix(int[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            matrix[r] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }
    }
}
