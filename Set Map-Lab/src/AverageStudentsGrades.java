import java.text.DecimalFormat;
import java.util.*;

public class AverageStudentsGrades {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Map<String, List<Double>> students = new TreeMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] read = scanner.nextLine().split("\\s+");
            students.putIfAbsent(read[0], new ArrayList<>());
            students.get(read[0]).add(Double.parseDouble(read[1]));
        }
        students.forEach((k, v) -> {
            System.out.println(String.format("%s -> %s(avg: %s)", k, getGrades(v), getAvg(v)));
        });
    }

    private static String getAvg(List<Double> v) {
        int count = 0;
        double sum = 0;
        for (Double aDouble : v) {
            sum += aDouble;
            count++;
        }
        return String.format("%.2f", sum / count);

        // return   v.stream().mapToDouble(Double::doubleValue).average().orElse(0.00);
    }

    private static String getGrades(List<Double> v) {
        String line = "";
        for (Double aDouble : v) {
            line += String.format("%.2f ", aDouble);
        }
        return line;
    }
}
