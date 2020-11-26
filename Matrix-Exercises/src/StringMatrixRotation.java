import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringMatrixRotation {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int degrees = getRotation();
        if (degrees > 270) {
            degrees = getValidDegrees(degrees);
        }

        String read;
        ArrayDeque<String> lines = new ArrayDeque<>();
        int longestSequens = 0;
        while (!"END".equals(read = scanner.nextLine())) {
            if (longestSequens < read.length()) {
                longestSequens = read.length();
            }
            lines.offer(read);
        }

        String[][] matrix = setMatrix(degrees, lines, longestSequens);
        printMatrix(matrix);
    }

    private static void printMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static String[][] setMatrix(int degrees, ArrayDeque<String> lines, int longestSequens) {

        String[][] matrix;

        switch (degrees) {
            case 0:
                matrix = new String[lines.size()][longestSequens];
                while (!lines.isEmpty()) {
                    for (int r = 0; r < matrix.length; r++) {
                        matrix[r] = lines.poll().split("");
                    }
                }
                break;
            case 90:
                matrix = new String[longestSequens][lines.size()];
                while (!lines.isEmpty()) {
                    for (int c = matrix[0].length - 1; c >= 0; c--) {
                        String[] box = lines.poll().split("");
                        int count = 0;
                        for (int r = 0; r < longestSequens; r++) {
                            if (count >= box.length) {
                                matrix[r][c] = " ";
                            } else {
                                matrix[r][c] = box[count++];

                            }
                        }
                    }
                }
                break;
            case 180:
                matrix = new String[lines.size()][longestSequens];
                while (!lines.isEmpty()) {
                    for (int r = matrix.length - 1; r >= 0; r--) {
                        int count = 0;
                        String[] box = lines.poll().split("");
                        for (int c = longestSequens - 1; c >= 0; c--) {
                            if (count >= box.length) {
                                matrix[r][c] = " ";
                            } else {
                                matrix[r][c] = box[count++];
                            }
                        }
                    }
                }
                break;
            case 270:
                matrix = new String[longestSequens][lines.size()];
                while (!lines.isEmpty()) {
                    for (int c = 0; c < matrix[0].length; c++) {
                        int count = 0;
                        String[] box = lines.poll().split("");
                        for (int r = matrix.length - 1; r >= 0; r--) {
                            if (count == box.length) {
                                matrix[r][c] = " ";
                            } else {
                                matrix[r][c] = box[count++];
                            }
                        }
                    }
                }
                break;
            default:
                matrix = new String[0][0];
        }
        return matrix;
    }

    private static int getValidDegrees(int degrees) {
        while (degrees > 270) {
            degrees %= 360;
        }
        return degrees;
    }

    private static int getRotation() {
        String read = scanner.nextLine();
        Pattern pattern = Pattern.compile("Rotate\\((?<dergees>\\d+)\\)");
        Matcher matcher = pattern.matcher(read);
        if (matcher.find()) {
            return Integer.parseInt(matcher.group("dergees"));
        }
        return 0;
    }
}
