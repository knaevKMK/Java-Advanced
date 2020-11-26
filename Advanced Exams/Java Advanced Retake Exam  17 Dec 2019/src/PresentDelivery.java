import java.util.Scanner;

public class PresentDelivery {
    private static Scanner scanner = new Scanner(System.in);
    private static int presents;
    private static String[][] matrix;
    private static int[] santa;
    private static int niceKid;
    private static boolean isHappy = false;


    public static void main(String[] args) {
        loadGame();
        runGame();
        printMatrix();
        result();
    }

    private static void result() {
        if (santa[2] >= niceKid) {
            System.out.println("Good job, Santa! " + niceKid + " happy nice kid/s.");
        } else {
            System.out.println("No presents for " + (niceKid - santa[2]) + " nice kid/s.");
        }
    }

    private static void printMatrix() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void runGame() {

        while (true) {
            switch (scanner.nextLine()) {
                case "Christmas morning":
                    return;
                case "up":
                    santa[0]--;
                    break;
                case "down":
                    santa[0]++;
                    break;
                case "left":
                    santa[1]--;
                    break;
                case "right":
                    santa[1]++;
                    break;
            }
            matrix[santa[0]][santa[1]] = "-";
            if (santa[0] < 0 || santa[0] >= matrix.length || santa[1] < 0 || santa[1] >= matrix.length) {
                System.out.println("Santa ran out of presents!");
                return;
            }

            switch (matrix[santa[0]][santa[1]]) {
                case "V":
                    matrix[santa[0]][santa[1]] = "S";
                    presents--;
                    santa[2] += 1;
                    break;
                case "X":
                    matrix[santa[0]][santa[1]] = "S";
                    break;
                case "C":
                    matrix[santa[0]][santa[1]] = "S";
                    String step = matrix[santa[0] - 1][santa[1]];
                    if (!step.equals("-") && !step.equals("C")) { // up
                        presents--;
                        if (matrix[santa[0] - 1][santa[1]].equals("V")) {
                            santa[2] += 1;
                        }
                        matrix[santa[0] - 1][santa[1]] = "-";
                        if (presents <= 0 && niceKid == santa[2]) {
                            return;
                        }
                        if (presents <= 0) {
                            System.out.println("Santa ran out of presents!");
                            return;

                        }
                    }
                    step = matrix[santa[0] + 1][santa[1]];
                    if (!step.equals("-") && !step.equals("C")) {//down
                        presents--;
                        if (matrix[santa[0] + 1][santa[1]].equals("V")) {
                            santa[2] += 1;
                        }
                        matrix[santa[0] + 1][santa[1]] = "-";
                        if (presents <= 0 && niceKid == santa[2]) {
                            return;
                        }
                        if (presents <= 0) {
                            System.out.println("Santa ran out of presents!");
                            return;

                        }
                    }
                    step = matrix[santa[0]][santa[1] - 1];
                    if (!step.equals("-") && !step.equals("C")) {//left
                        presents--;
                        if (matrix[santa[0]][santa[1] - 1].equals("V")) {
                            santa[2] += 1;
                        }
                        matrix[santa[0]][santa[1] - 1] = "-";
                        if (presents <= 0 && niceKid == santa[2]) {
                            return;
                        }
                        if (presents <= 0) {
                            System.out.println("Santa ran out of presents!");
                            return;

                        }
                    }
                    step = matrix[santa[0]][santa[1] + 1];
                    if (!step.equals("-") && !step.equals("C")) {//right
                        presents--;
                        if (matrix[santa[0]][santa[1] + 1].equals("V")) {
                            santa[2] += 1;
                        }
                        matrix[santa[0]][santa[1] + 1] = "-";
                        if (presents <= 0 && niceKid == santa[2]) {
                            return;
                        }
                        if (presents <= 0) {
                            System.out.println("Santa ran out of presents!");
                            return;

                        }
                    }

                    break;
            }

            if (presents == 0 && niceKid == santa[2]) {
                System.out.println("Santa ran out of presents!");
                return;
            }
        }
    }

    private static void loadGame() {
        presents = Integer.parseInt(scanner.nextLine());
        santa = new int[3];//row, coll, kidV
        createMatrix(Integer.parseInt(scanner.nextLine()));
    }

    private static void createMatrix(int n) {

        matrix = new String[n][n];
        for (int i = 0; i < n; i++) {
            matrix[i] = scanner.nextLine().split(" ");
            for (int j = 0; j < n; j++) {
                switch (matrix[i][j]) {
                    case "S":
                        santa[0] = i;
                        santa[1] = j;
                        break;
                    case "V":
                        niceKid++;
                        break;
                }
            }
        }
    }
}