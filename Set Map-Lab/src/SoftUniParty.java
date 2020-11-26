import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> vip = new TreeSet<>();
        Set<String> guest = new TreeSet<>();

        String input;
        while (!"PARTY".equals(input = scanner.nextLine())) {
            if (input.length() == 8) {
                if (Character.isDigit(input.charAt(0))) {
                    vip.add(input);
                } else {
                    guest.add(input);
                }
            }
        }

        while (!"END".equals(input = scanner.nextLine())) {
            if (Character.isDigit(input.charAt(0))) {
                vip.remove(input);
            } else {
                guest.remove(input);
            }
        }
        System.out.println(vip.size() + guest.size());
        for (String s : vip) {
            System.out.println(s);
        }
        for (String s : guest) {
            System.out.println(s);
        }
    }
}
