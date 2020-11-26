import java.util.Scanner;

public class TheHeiganDance {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        double scoreHintHeigan = Double.parseDouble(scanner.nextLine());

        int[] player = {18500, 7, 7, 0};
        double heigen = 3000000;
        int[][] table = new int[15][15];
        String lastSpell = "";

        while (true) {
            if (player[0] >= 0) {
                heigen -= scoreHintHeigan;
            }
            if (player[3] != 0 && lastSpell.equals("Cloud")) {
                player[0] = player[0] - 3500;
            }
            if (player[0] <= 0 || heigen <= 0) {
                break;
            }

            String[] line = scanner.nextLine().split("\\s+");
            defaultTable(table);

            lastSpell = line[0];
            int row = Integer.parseInt(line[1]);
            int col = Integer.parseInt(line[2]);
            setDamage(table, row, col);

            int dethScore;
            switch (lastSpell) {
                case "Cloud":
                    dethScore = 3500;
                    break;
                case "Eruption":
                    dethScore = 6000;
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + lastSpell);
            }
            if (table[player[1]][player[2]] == 1) {
                setPlayerHealtOrPosition(player, table, dethScore);
            }
        }
        lastSpell = lastSpell.equals("Cloud") ? "Plague Cloud" : "Eruption";
        System.out.println("Heigan: " + (heigen <= 0 ? "Defeated!" : String.format("%.2f", heigen)));
        System.out.println("Player: " + (player[0] <= 0 ? "Killed by " + lastSpell : player[0]));
        System.out.println("Final position: " + player[1] + ", " + player[2]);

    }

    private static void defaultTable(int[][] table) {
        for (int r = 0; r < 15; r++) {
            table[r] = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        }

    }

    private static void setPlayerHealtOrPosition(int[] player, int[][] table, int dethScore) {
        int rowP = player[1];
        int colP = player[2];
        if (rowP - 1 >= 0 && table[rowP - 1][colP] == 0) {//up
            player[1] = rowP - 1;
            player[3] = 0;
            return;
        }
        if (colP + 1 < 15 && table[rowP][colP + 1] == 0) {//right
            player[2] = colP + 1;
            player[3] = 0;
            return;
        }
        if (rowP + 1 < 15 && table[rowP + 1][colP] == 0) {//down
            player[1] = rowP + 1;
            player[3] = 0;
            return;
        }
        if (colP - 1 >= 0 && table[rowP][colP - 1] == 0) {//left
            player[2] = colP - 1;
            player[3] = 0;
            return;
        }
        int playerHealth = player[0];
        playerHealth -= dethScore;
        player[0] = playerHealth;
        player[3] = -1;
    }

    private static void setDamage(int[][] table, int row, int col) {
        for (int r = -1; r <= 1; r++) {
            for (int c = -1; c <= 1; c++) {
                if (validIndex((row + r), (col + c))) {
                    table[row + r][col + c] = 1;
                }
            }
        }
    }

    private static boolean validIndex(int row, int col) {
        return row >= 0 && row < 15 && col >= 0 && col < 15;
    }
}
