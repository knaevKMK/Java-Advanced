import java.text.DecimalFormat;
import java.util.*;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> list = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            list.putIfAbsent(name, new ArrayList<>());
            double[] grades = Arrays.stream(scanner.nextLine().split("\\s")).mapToDouble(Double::parseDouble).toArray();
            for (double grade : grades) {
                list.get(name).add(grade);
            }
        }
        list.entrySet().stream()
                //.sorted((f, s) -> Double.compare(getAvg(f.getValue()), getAvg(s.getValue())))
                .forEach(e -> System.out.println(e.getKey() + " is graduated with " + getAvg(e.getValue())));
    }

    private static String getAvg(List<Double> value) {
     //   DecimalFormat dc =new DecimalFormat("#.#####");
        int count = 0;
        double sum = 0;
        for (Double aDouble : value) {
            sum += aDouble;
            count++;
        }
        return ""+(sum / count);
    }
}
