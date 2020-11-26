import java.util.*;

public class Bombs {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayDeque<Integer> effects = new ArrayDeque<>();
        createQue(effects);
        ArrayDeque<Integer> casings = new ArrayDeque<>();
        createStack(casings);
        Map<String, Integer> bombs = new TreeMap<>();
        putBombs(bombs);

        while (!effects.isEmpty() && !casings.isEmpty()) {
            int effect = effects.pop();
            int casing = casings.pop();
            int sum = effect + casing;
            switch (sum) {
                case 40:
                    bombs.put("Datura Bombs: ", bombs.get("Datura Bombs: ") + 1);
                    break;
                case 60:
                    bombs.put("Cherry Bombs: ", bombs.get("Cherry Bombs: ") + 1);
                    break;
                case 120:
                    bombs.put("Smoke Decoy Bombs: ", bombs.get("Smoke Decoy Bombs: ") + 1);
                    break;
                default:
                    if (casing > 0) {
                        casings.push(casing - 5);
                    }
                    effects.push(effect);
            }
            if (enzoCollectBomb(bombs)) {
                break;
            }
        }
        if (enzoCollectBomb(bombs)) {
            print("Bene! You have successfully filled the bomb pouch!");
        } else {
            print("You don't have enough materials to fill the bomb pouch.");
        }
        print("Bomb Effects: " + getEffects(effects));
        print("Bomb Casings: " + getEffects(casings));
        print(getBombList(bombs));
    }

    private static String getBombList(Map<String, Integer> bombs) {
        StringBuilder print = new StringBuilder();
        for (Map.Entry<String, Integer> entry : bombs.entrySet()) {
            print.append(entry.getKey()).append(entry.getValue()).append(System.lineSeparator());
        }
        return print.toString();
    }

    private static String getEffects(ArrayDeque<Integer> list) {
        if (list.isEmpty()) {
            return "empty";
        }
        StringBuilder print = new StringBuilder();
        while (!list.isEmpty()) {
            print.append(list.pop()).append(", ");
        }
        return print.toString().substring(0, print.length() - 2);
    }

    private static void print(String s) {
        System.out.println(s);
    }

    private static boolean enzoCollectBomb(Map<String, Integer> bombs) {
        for (Integer value : bombs.values()) {
            if (value < 3) {
                return false;
            }
        }
        return true;
    }

    private static void putBombs(Map<String, Integer> bombs) {
        bombs.putIfAbsent("Datura Bombs: ", 0);
        bombs.putIfAbsent("Cherry Bombs: ", 0);
        bombs.putIfAbsent("Smoke Decoy Bombs: ", 0);
    }

    private static void createQue(ArrayDeque<Integer> effect) {
        String[] read = scanner.nextLine().split(",\\s+");
        for (String s : read) {
            effect.offer(Integer.parseInt(s));
        }
    }

    private static void createStack(ArrayDeque<Integer> casing) {
        String[] read = scanner.nextLine().split(",\\s+");
        for (String s : read) {
            casing.push(Integer.parseInt(s));
        }
    }
}
