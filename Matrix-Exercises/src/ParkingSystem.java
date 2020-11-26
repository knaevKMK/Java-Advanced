
import java.util.*;

public class ParkingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        scanner.nextLine();


        boolean[][] parking = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            parking[i][0] = true;
        }

        String read;
        while (!"stop".equals(read = scanner.nextLine())) {
            String[] token = read.split("\\s");

            int steps = getSteps(token, parking);
            if (steps == 0) {
                System.out.println("Row " + token[1] + " full");
                continue;
            }
            System.out.println(steps);

        }
    }

    private static int getSteps(String[] token, boolean[][] parking) {
        int start = Integer.parseInt(token[0]);
        int rowSpot = Integer.parseInt(token[1]);
        int colSpot = Integer.parseInt(token[2]);
        int steps = Math.abs(start - rowSpot) + 1;

        if (isNotFreeRow(parking[rowSpot])) {
            return 0;
        }
        if (!parking[rowSpot][colSpot]) {
            parking[rowSpot][colSpot] = true;
            return steps + colSpot;
        } else {
            for (int newxtCol = 1; newxtCol <= Math.max(colSpot, parking[rowSpot].length - colSpot); newxtCol++) {
                int nextCol = colSpot - newxtCol;
                if (nextCol > 0 &&
                        !parking[rowSpot][nextCol]) {
                    parking[rowSpot][nextCol] = true;
                    return steps + nextCol;
                }
                nextCol = colSpot + newxtCol;
                if (nextCol < parking[rowSpot].length &&
                        !parking[rowSpot][nextCol]) {
                    parking[rowSpot][nextCol] = true;
                    return steps + nextCol;
                }
            }
        }
        return 0;
    }

    private static boolean isNotFreeRow(boolean[] booleans) {
        for (boolean aBoolean : booleans) {
            if (!aBoolean) {
                return false;
            }
        }
        return true;
    }
}
