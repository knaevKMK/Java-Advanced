import javax.swing.*;
import javax.swing.plaf.IconUIResource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Crossfire {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<List<Integer>> matrix = getMatrix();
        setMatrix(matrix);
        printMatrix(matrix);
    }

    private static void printMatrix(List<List<Integer>> matrix) {
        for (int r = 0; r < matrix.size(); r++) {
            for (int c = 0; c < matrix.get(r).size(); c++) {
                System.out.print(matrix.get(r).get(c) + " ");
            }
            System.out.println();
        }
    }

    private static void setMatrix(List<List<Integer>> matrix) {
        String read;
        while (!"Nuke it from orbit".equals(read = scanner.nextLine())) {
            int[] value = Arrays.stream(read.split("\\s")).mapToInt(Integer::parseInt).toArray();
            int row = value[0];
            int col = value[1];
            int radius = value[2];

            for (int i = radius + row; i >= row - radius; i--) {
                if (i == row) {
                    continue;
                }
                if (isInRange(i, col, matrix)) {
                    matrix.get(i).remove(col);
                }

            }
            for (int i = col + radius; i >= (col - radius); i--) {
                if (isInRange(row, i, matrix)) {
                    matrix.get(row).remove(i);
                }
            }
            matrix.removeIf(List::isEmpty);
        }
    }

    private static boolean isInRange(int row, int col, List<List<Integer>> matrix) {
        return row >= 0 && row < matrix.size() && col >= 0 && col < matrix.get(row).size();
    }

    private static List<List<Integer>> getMatrix() {
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        scanner.nextLine();
        List<List<Integer>> matrix = new ArrayList<>();
        int value = 1;
        for (int r = 0; r < row; r++) {
            matrix.add(r, new ArrayList<>());
            for (int c = 0; c < col; c++) {
                matrix.get(r).add(value++);
            }
        }
        return matrix;
    }
}
