import java.util.Scanner;

public class FilltheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(",\\s+");
        int[][] matrix = getMatrix(input);
        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] +" ");
            }
            System.out.println();
        }
    }

    private static int[][] getMatrix(String[] input) {
        int size = Integer.parseInt(input[0]);
        int[][] matrix = new int[size][size];
        switch (input[1]) {
            case "A":
                fillCaseA(matrix);
                break;
            case "B":
                fillCaseB(matrix);
                break;
        }

        return matrix;
    }

    private static int[][] fillCaseB(int[][] matrix) {
        int value = 1;
        for (int i = 0; i < matrix.length; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < matrix.length; j++) {
                    matrix[j][i] = value++;
                }
            } else {
                for (int j = matrix.length - 1; j >= 0; j--) {
                    matrix[j][i] = value++;
                }
            }
        }
        return matrix;
    }

    private static int[][] fillCaseA(int[][] matrix) {
        int value = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[j][i] = value++;
            }
        }
        return matrix;
    }
}
