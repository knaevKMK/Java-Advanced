import java.util.Scanner;

public class BookWorm {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        StringBuilder line = new StringBuilder(scanner.nextLine());

        int n = Integer.parseInt(scanner.nextLine());
        String[][] shape = new String[n][n];
        createShape(shape);
        int[] player = new int[2];
        getPosition(player, shape);

        String read;
        while (!"end".equals(read = scanner.nextLine())) {
            shape[player[0]][player[1]] = "-";

            switch (read) {
                case "up":
                    if (!isOutOfBounds(player[0] - 1, shape)) {
                        cutLastChar(line);
                    } else {
                        player[0] -= 1;
                    }
                    break;
                case "down":
                    if (!isOutOfBounds(player[0] + 1, shape)) {
                        cutLastChar(line);
                    } else {
                        player[0] += 1;
                    }
                    break;
                case "left":
                    if (!isOutOfBounds(player[1] - 1, shape)) {
                        cutLastChar(line);
                    } else {
                        player[1] -= 1;
                    }
                    break;
                case "right":
                    if (!isOutOfBounds(player[1] + 1, shape)) {
                        cutLastChar(line);
                    } else {
                        player[1] += 1;
                    }
                    break;
            }

            switch (shape[player[0]][player[1]]) {
                case "-":
                    break;
                default:
                    line.append(shape[player[0]][player[1]]);
            }
            shape[player[0]][player[1]] = "P";
        }
        System.out.println(line);
        printMatrix(shape);
    }

    private static void printMatrix(String[][] shape) {
        for (String[] strings : shape) {
            for (String string : strings) {
                System.out.print(string);
            }
            System.out.println();
        }
    }

    private static void cutLastChar(StringBuilder line) {
        line.deleteCharAt(line.length() - 1);
    }

    private static boolean isOutOfBounds(int position, String[][] shape) {
        if (position >= 0 && position < shape.length) {
            return true;
        }
        return false;
    }


    private static void getPosition(int[] player, String[][] shape) {
        for (int i = 0; i < shape.length; i++) {
            for (int j = 0; j < shape[i].length; j++) {
                if ("P".equals(shape[i][j])) {
                    player[0] = i;
                    player[1] = j;
                    return;
                }
            }
        }
    }

    private static void createShape(String[][] shape) {
        for (int i = 0; i < shape.length; i++) {
            shape[i] = scanner.nextLine().split("");
        }
    }
}
