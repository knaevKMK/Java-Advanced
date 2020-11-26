import java.util.*;

public class Garden {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] size = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[][] matrix = new int[size[0]][size[1]];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = 0;
            }
        }
        ArrayDeque<int[]> list = new ArrayDeque<>();

        String read;
        while (!"Bloom Bloom Plow".equals(read = scanner.nextLine())) {

            int[] position = Arrays.stream(read.split(" ")).mapToInt(Integer::parseInt).toArray();

            if (checkOutOfBounds(position, size)) {
                System.out.println("Invalid coordinates.");
            } else {
                list.offer(position);
            }
        }


        while (!list.isEmpty()) {
            int[] flowers = list.poll();

            for (int row = 0; row < size[0]; row++) {
                if (row == flowers[0]) {
                    continue;
                }
                matrix[row][flowers[1]] += 1;
            }
            for (int coll = 0; coll < size[1]; coll++) {
                matrix[flowers[0]][coll] += 1;
            }
        }
        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static boolean checkOutOfBounds( int[] position, int[] size) {
        return position[0] < 0 || position[0] >= size[0] || position[1] < 0 || position[1] >= size[1];
    }


}
