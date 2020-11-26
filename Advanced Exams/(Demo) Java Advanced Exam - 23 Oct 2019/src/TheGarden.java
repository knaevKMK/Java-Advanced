import java.util.*;

public class TheGarden {
    private static Scanner scanner = new Scanner(System.in);
    private static String[][] matrix;
    private static Map<String, Integer> list = new LinkedHashMap<>();
    private static int harmed;


    public static void main(String[] args) {
        load();
        run();
        result();
    }

    private static void result() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        for (Map.Entry<String, Integer> e : list.entrySet()) {
            System.out.println(e.getKey() + ": " + e.getValue());
        }
        System.out.println("Harmed vegetables: " + harmed);
    }

    private static void run() {
        String read;
        while (!"End of Harvest".equals(read = scanner.nextLine())) {
            String[] token = read.split("\\s+");
            int row = Integer.parseInt(token[1]);
            int col = Integer.parseInt(token[2]);
            if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[row].length) {
                continue;
            }
            switch (token[0]) {
                case "Harvest":
                    collectVeg(row, col);
                    break;
                case "Mole":

                    switch (token[3]) {
                        case "up":
                            for (int i = row; i >= 0; i -= 2) {
                                if (!matrix[i][col].equals(" ")) {
                                    matrix[i][col] = " ";
                                    harmed++;
                                }
                            }
                            break;
                        case "down":
                            for (int i = row; i < matrix.length; i += 2) {
                                if (!matrix[i][col].equals(" ")) {
                                    matrix[i][col] = " ";
                                    harmed++;
                                }
                            }
                            break;
                        case "left":
                            for (int i = col; i >= 0; i -= 2) {
                                if (!matrix[row][i].equals(" ")) {
                                    matrix[row][i] = " ";
                                    harmed++;
                                }
                            }
                            break;
                        case "right":
                            for (int i = col; i < matrix[row].length; i += 2) {
                                if (!matrix[row][i].equals(" ")) {
                                    matrix[row][i] = " ";
                                    harmed++;
                                }
                            }
                            break;
                    }

                    break;
            }
        }
    }

    private static void collectVeg(int row, int col) {
        if (!matrix[row][col].equals(" ")) {
            String temp = matrix[row][col];
            switch (temp) {
                case "L":
                    list.putIfAbsent("Lettuce", 0);
                    list.put("Lettuce", list.get("Lettuce") + 1);
                    break;
                case "P":
                    list.putIfAbsent("Potatoes", 0);
                    list.put("Potatoes", list.get("Potatoes") + 1);
                    break;
                case "C":
                    list.putIfAbsent("Carrots", 0);
                    list.put("Carrots", list.get("Carrots") + 1);
                    break;
            }
            matrix[row][col] = " ";
        }
    }

    private static void load() {
        int n = Integer.parseInt(scanner.nextLine());
        matrix = new String[n][];
        for (int i = 0; i < n; i++) {
            matrix[i] = scanner.nextLine().split(" ");
        }
        //•	Lettuce  – 'L', Potatoes – 'P', Carrots  – 'C'

        list.putIfAbsent("Carrots", 0);
        list.putIfAbsent("Potatoes", 0);
        list.putIfAbsent("Lettuce", 0);
    }
}
