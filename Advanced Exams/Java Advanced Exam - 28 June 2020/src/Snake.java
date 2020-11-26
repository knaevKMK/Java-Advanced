import java.util.Scanner;

public class Snake {
    private static Scanner scanner = new Scanner(System.in);
    private static int food;
    private static int[] snake = new int[2];

    public static void main(String[] args) {
        int n = Integer.parseInt(scanner.nextLine());
        String[][] shape = new String[n][n];
        createShape(shape);

        while (true) {
            shape[snake[0]][snake[1]] = ".";

            String read = scanner.nextLine();
            switch (read) {
                case "up":
                    snake[0] -= 1;
                    break;
                case "down":
                    snake[0] += 1;
                    break;
                case "left":
                    snake[1] -= 1;
                    break;
                case "right":
                    snake[1] += 1;
                    break;
            }
            if (snakeIsInside(shape.length, snake)) {
                print("Game over!");
                break;
            }
            switch (shape[snake[0]][snake[1]]) {
                case "*":
                    food++;
                    shape[snake[0]][snake[1]] = "S";
                    break;
                case "B":
                    shape[snake[0]][snake[1]] = ".";
                    findNextB(shape);
                    break;
            }
            if (food >= 10) {
                print("You won! You fed the snake.");
                break;
            }
        }
        print("Food eaten: " + food);
        print(getMatrix(shape));
    }

    private static String getMatrix(String[][] shape) {
        StringBuilder print = new StringBuilder();
        for (int i = 0; i < shape.length; i++) {
            for (int j = 0; j < shape.length; j++) {
                print.append(shape[i][j]);
            }
            print.append(System.lineSeparator());
        }
        return print.toString().trim();
    }

    private static void print(String s) {
        System.out.println(s);
    }

    private static void findNextB(String[][] shape) {
        for (int i = 0; i < shape.length; i++) {
            for (int j = 0; j < shape.length; j++) {
                if ("B".equals(shape[i][j])) {
                    shape[i][j] = "S";
                    snake[0] = i;
                    snake[1] = j;
                    return;
                }
            }
        }
    }

    private static boolean snakeIsInside(int length, int[] snake) {
        if (snake[0] >= 0 && snake[0] < length && snake[1] >= 0 && snake[1] < length) {
            return false;
        }
        return true;
    }


    private static void createShape(String[][] shape) {
        for (int i = 0; i < shape.length; i++) {
            shape[i] = scanner.nextLine().split("");
            for (int j = 0; j < shape[i].length; j++) {
                if ("S".equals(shape[i][j])) {
                    snake[0] = i;
                    snake[1] = j;
                }
            }
        }
    }
}