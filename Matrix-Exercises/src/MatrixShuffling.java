import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String[][] matrix = getMatrix();
        setMatrix(matrix);
    }

    private static void setMatrix(String[][] matrix) {
        String read;
        while (!"END".equals(read = scanner.nextLine())) {
            String[] token = read.split("\\s+");
            if (token.length == 5) {
                if ("swap".equals(token[0])) {
                    int rFirst = Integer.parseInt(token[1]);
                    int cFirst = Integer.parseInt(token[2]);
                    int rSecond = Integer.parseInt(token[3]);
                    int cSecond = Integer.parseInt(token[4]);
                    if (rFirst >= 0 && rFirst <= matrix.length
                            && cFirst >= 0 && cFirst <= matrix[0].length
                            && rSecond >= 0 && rSecond <= matrix.length
                            && cSecond >= 0 && cSecond <= matrix[0].length) {
                        String temp = matrix[rFirst][cFirst];
                        matrix[rFirst][cFirst] = matrix[rSecond][cSecond];
                        matrix[rSecond][cSecond] = temp;
                        printMatrix(matrix);
                        continue;
                    }

                }
            }
            printError();
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            System.out.println(Arrays.toString(matrix[r]).replaceAll("[\\[\\],]", ""));
        }
    }

    private static void printError() {
        System.out.println("Invalid input!");
    }

    private static String[][] getMatrix() {
        int rows = scanner.nextInt();;
        int columns = scanner.nextInt();
        scanner.nextLine();
        String[][] matrix = new String[rows][columns];
        for (int r = 0; r < rows; r++) {
            matrix[r] = scanner.nextLine().split("\\s+");
        }
        return matrix;
    }
}
