import java.util.Scanner;

public class ReVolt {
    private static Scanner scanner = new Scanner(System.in);
    private static int n = Integer.parseInt(scanner.nextLine());
    private static int command = Integer.parseInt(scanner.nextLine());
    private static String[][] matrix;
    private static int[] player = new int[2];

    public static void main(String[] args) {
        load();
        run(scanner.nextLine());
        printMatrix();
    }

    private static void printMatrix() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static void run(String read) {

        String lastPosition;
        for (int i = command; i > 0; i--) {
            lastPosition = player[0] + " " + player[1] + " ";
            if (!matrix[player[0]][player[1]].equals("B")) {
                matrix[player[0]][player[1]] = "-";
            }
            switch (read) {
                case "up":
                    player[0] -= 1;
                    break;
                case "down":
                    player[0] += 1;
                    break;
                case "left":
                    player[1] -= 1;
                    break;
                case "right":
                    player[1] += 1;
                    break;
            }
            checkOtuOfBoundsPosition();
            switch (matrix[player[0]][player[1]]) {
                case "F":
                    matrix[player[0]][player[1]] = "f";
                    System.out.println("Player won!");
                    return;
                case "B":
                    i++;
                    continue;
                case "T":
                    String[] token = lastPosition.split(" ");
                    player[0] = Integer.parseInt(token[0]);
                    player[1] = Integer.parseInt(token[1]);
                    break;
            }
            matrix[player[0]][player[1]] = "f";
            if (i > 1) {
                read = scanner.nextLine();
            }
        }
        System.out.println("Player lost!");
    }


    private static void checkOtuOfBoundsPosition() {
        if (player[0] < 0) {
            player[0] = matrix.length - 1;
        } else if (player[0] >= matrix.length) {
            player[0] = 0;
        }
        if (player[1] < 0) {
            player[1] = matrix.length - 1;
        } else if (player[1] >= matrix.length) {
            player[1] = 0;
        }
    }

    private static void load() {


        matrix = new String[n][n];
        for (int i = 0; i < n; i++) {
            matrix[i] = scanner.nextLine().split("\\s*");
            for (int j = 0; j < n; j++) {
                switch (matrix[i][j]) {
                    case "f":
                        player[0] = i;
                        player[1] = j;
                        break;
                }

            }
        }
    }
}
