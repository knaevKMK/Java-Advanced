import java.util.ArrayDeque;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Exercize1 {
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayDeque<Integer> materials = new ArrayDeque<>();
    private static ArrayDeque<Integer> magics = new ArrayDeque<>();
    private static Map<String, Integer> presents = new TreeMap<>();

    public static void main(String[] args) {

        load();
        run();
        result();
    }

    private static void result() {
        if (checkDone()) {
            System.out.println("The presents are crafted! Merry Christmas!");
        } else {
            System.out.println("No presents this Christmas!");
        }
        printResult("Materials left: ", materials);
        printResult("Magic left: ", magics);
        presents.forEach((present, count) -> {
            if (count > 0) {
                System.out.println(present + ": " + count);
            }
        });
    }

    private static void run() {
        while (!magics.isEmpty() && !materials.isEmpty()) {
            int material = materials.pop();
            int magic = magics.poll();
            int result = magic * material;

            switch (result) {
                case 0:
                    if (material != 0) {
                        materials.push(material);
                    }
                    if (magic != 0) {
                        magics.push(magic);
                    }
                    break;
                case 150:
                    addMap("Doll", 1);
                    break;
                case 250:
                    addMap("Wooden train", 1);
                    break;
                case 300:
                    addMap("Teddy bear", 1);
                    break;
                case 400:
                    addMap("Bicycle", 1);
                    break;
                default:
                    if (result < 0) {
                        materials.push(material + magic);
                    } else {
                        materials.push(material + 15);
                    }
                    break;
            }
        }
    }


    private static void printResult(String s, ArrayDeque<Integer> list) {
        if (list.isEmpty()) {
            return;
        }
        StringBuilder print = new StringBuilder(s);
        while (!list.isEmpty()) {
            print.append(list.pop() + ", ");
        }
        System.out.println(print.toString().substring(0, print.length() - 2));
    }

    private static boolean checkDone() {
        return ((presents.get("Doll") > 0 && presents.get("Wooden train") > 0)
                || (presents.get("Teddy bear") > 0 && presents.get("Bicycle") > 0));

    }

    private static void addMap(String s, int i) {
        presents.put(s, presents.get(s) + 1);
    }


    private static void load() {
        String[] token = scanner.nextLine().split("\\s+");
        for (String s : token) {
            materials.push(Integer.parseInt(s));

        }
        token = scanner.nextLine().split("\\s+");
        for (String s : token) {
            magics.offer(Integer.parseInt(s));

        }
        presents.putIfAbsent("Doll", 0);
        presents.putIfAbsent("Wooden train", 0);
        presents.putIfAbsent("Teddy bear", 0);
        presents.putIfAbsent("Bicycle", 0);

    }

}
