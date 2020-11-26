import java.util.Scanner;

public class MaximalSum {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int rows = scanner.nextInt();
        int columns = scanner.nextInt();
        int[][] matrix = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        int[][] maxMatrix = new int[3][3];
        int maxSum = getMaxSum(matrix, maxMatrix);
        System.out.println("Sum = " + maxSum);
        printMatrix(maxMatrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int getMaxSum(int[][] matrix, int[][] subMatrix) {
        int sum = Integer.MIN_VALUE;

        for (int r = 0; r <= matrix.length - 3; r++) {
            for (int c = 0; c <= matrix[r].length-3; c++) {
                int checkSum = matrix[r][c] + matrix[r][c + 1] + matrix[r][c + 2] +
                        matrix[r + 1][c] + matrix[r + 1][c + 1] + matrix[r + 1][c + 2] +
                        matrix[r + 2][c] + matrix[r + 2][c + 1] + matrix[r + 2][c + 2];

                if (sum < checkSum) {
                    sum = checkSum;
                    subMatrix[0][0] = matrix[r][c];
                    subMatrix[0][1] = matrix[r][c + 1];
                    subMatrix[0][2] = matrix[r][c + 2];
                    subMatrix[1][0] = matrix[r + 1][c];
                    subMatrix[1][1] = matrix[r + 1][c + 1];
                    subMatrix[1][2] = matrix[r + 1][c + 2];
                    subMatrix[2][0] = matrix[r + 2][c];
                    subMatrix[2][1] = matrix[r + 2][c + 1];
                    subMatrix[2][2] = matrix[r + 2][c + 2];

                }
            }
        }
        return sum;
    }
}
