import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> que = new ArrayDeque<>();
        String current = "";
        que.push(current);
        for (int i = 0; i < n; i++) {
            String[] token = scanner.nextLine().split("\\s+");
            current = que.peek();
            switch (token[0]) {
                case "1":
                    current += token[1];
                    que.push(current);
                    break;

                case "2":
                    int delLast = Integer.parseInt(token[1]);
                    if (delLast < current.length()) {
                        current = current.substring(0, current.length() - delLast);
                    } else {
                        current = "";

                    }
                    que.push(current);
                    break;

                case "3":
                    int position = Integer.parseInt(token[1]) - 1;

                    if (position >= 0 && position < current.length()) {
                        System.out.println("" + current.charAt(position));
                    }
                    break;
                case "4":
                    que.pop();
                    break;
            }
        }
    }
}
