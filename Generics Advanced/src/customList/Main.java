package customList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String read;
        Data<String> data = new Data<>();
        while (!"END".equals(read = scanner.nextLine())) {
            String[] token = read.split("\\s");
            switch (token[0]) {
                case "Add":
                    data.add(token[1]);
                    break;
                case "Remove":
                    data.remove(Integer.parseInt(token[1]));
                    break;
                case "Contains":
                    System.out.println(data.contains(token[1]));
                    break;
                case "Swap":
                    data.swap(Integer.parseInt(token[1]), Integer.parseInt(token[2]));
                    break;
                case "Greater":
                    System.out.println(data.countGreaterThan(token[1]));
                    break;
                case "Max":
                    System.out.println(data.getMax());
                    break;
                case "Min":
                    System.out.println(data.getMin());
                    break;
                case "Print":
                    Sorter.sort(data);
                    System.out.print(data);
                    break;
            }
        }
    }
}
