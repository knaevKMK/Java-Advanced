import java.util.Scanner;

public class ReVolt {
    private static Scanner scanner = new Scanner(System.in);
    private static int[] player = new int[2];
    //   private static int[] lastPosition;
    private static String won = "";
    private static int n = Integer.parseInt(scanner.nextLine());
    private static String[][] shape = new String[n][n];

    public static void main(String[] args) {

        int m = Integer.parseInt(scanner.nextLine());
        createMatrix();

        for (int i = 0; i < m; i++) {
            String read = scanner.nextLine();
            String lastPosition = player[0] + "/" + player[1];

            shape[player[0]][player[1]] = "-";
            putPlayerPosition(read, lastPosition);


            if (won.equals("Player won!")) {
                System.out.println("Player won!");
                printMatrix();
                return;
            }
        }
        System.out.println("Player lost!");
        printMatrix();
    }

    private static void checkResult(String read, String lastPosition) {
        switch (shape[player[0]][player[1]]) {
            case "F":
                won = "Player won!";
                break;
            case "B":
                putPlayerPosition(read, lastPosition);
                return;
            case "T":
                String[] token = lastPosition.split("/");
                player[0] = Integer.parseInt(token[0]);
                player[1] = Integer.parseInt(token[1]);
                break;
        }
        shape[player[0]][player[1]] = "f";
    }

    private static void printMatrix() {
        for (String[] strings : shape) {
            for (String s : strings) {
                System.out.print(s);
            }
            System.out.println();
        }
    }

    private static void putPlayerPosition(String read, String lastPosition) {

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

        if (player[0] < 0) {
            player[0] = shape.length - 1;
        } else if (player[0] >= shape.length) {
            player[0] = 0;
        }

        if (player[1] < 0) {
            player[1] = shape.length - 1;
        } else if (player[1] >= shape.length) {
            player[1] = 0;
        }
        checkResult(read, lastPosition);
    }

    private static void createMatrix() {
        for (int i = 0; i < n; i++) {
            shape[i] = scanner.nextLine().split("");
            for (int j = 0; j < n; j++) {
                if (shape[i][j].equals("f")) {
                    player[0] = i;
                    player[1] = j;
                }
            }
        }
    }
}