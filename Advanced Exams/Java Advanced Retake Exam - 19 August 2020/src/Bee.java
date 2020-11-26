import java.util.Scanner;

public class Bee {
    public static Scanner scanner = new Scanner(System.in);
    private static int flower;

    public static void main(String[] args) {
        int n = Integer.parseInt(scanner.nextLine());
        String[][] shape = new String[n][n];
        createMatrix(shape);
        int[] bee = new int[2];
        getPosition(bee, shape);

        String read = scanner.nextLine();
        while (!"End".equals(read)) {
            shape[bee[0]][bee[1]] = ".";
            switch (read) {
                case "up":
                    bee[0] -= 1;
                    break;
                case "down":
                    bee[0] += 1;
                    break;
                case "left":
                    bee[1] -= 1;
                    break;
                case "right":
                    bee[1] += 1;
                    break;
            }
            if (beeIsOut(bee, shape)) {
                gameOver();
                printResult(flower);
                printMatrx(shape);
                return;
            }

            switch (shape[bee[0]][bee[1]]) {
                case "f":
                    flower++;
                    break;
                case "O":
                    shape[bee[0]][bee[1]] = "B";
                    continue;

            }
            shape[bee[0]][bee[1]] = "B";
            read = scanner.nextLine();
        }
        printResult(flower);
        printMatrx(shape);
    }

    private static boolean beeIsOut(int[] bee, String[][] shape) {
        if (bee[0] < 0 || bee[0] >= shape.length ||
                bee[1] < 0 || bee[1] >= shape.length) {
            return true;
        }
        return false;
    }

    private static void printMatrx(String[][] shape) {
        for (int i = 0; i < shape.length; i++) {
            for (int j = 0; j < shape.length; j++) {
                System.out.print(shape[i][j]);
            }
            System.out.println();
        }
    }

    private static void printResult(int flower) {
        if (flower >= 5) {
            System.out.println("Great job, the bee manage to pollinate " + flower + " flowers!");
        } else {
            System.out.println("The bee couldn't pollinate the flowers, she needed " + (5 - flower) + " flowers more");
        }
    }

    private static void gameOver() {
        System.out.println("The bee got lost!");
    }


    private static void getPosition(int[] bee, String[][] shape) {
        for (int row = 0; row < shape.length; row++) {
            for (int col = 0; col < shape[row].length; col++) {
                if ("B".equals(shape[row][col])) {
                    bee[0] = row;
                    bee[1] = col;
                    return;
                }
            }
        }
    }

    private static void createMatrix(String[][] shape) {
        for (int i = 0; i < shape.length; i++) {
            shape[i] = scanner.nextLine().split("");
        }
    }
}
