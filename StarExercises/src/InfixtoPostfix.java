import java.util.ArrayDeque;
import java.util.Scanner;

public class InfixtoPostfix {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> nums = new ArrayDeque<>(); // queue
        ArrayDeque<String> operators = new ArrayDeque<>();//stack

        String[] line = scanner.nextLine().split("\\s");
        for (String s : line) {
            if (Character.isLetterOrDigit(s.charAt(0))) {
                nums.offer((s));
            } else {
                if (operators.isEmpty()) {
                    operators.push(s);
                } else {
                    switch (s) {
                        case "+":
                        case "-":
                            if (!"(".equals(operators.peek())) {
                                nums.offer(operators.pop());
                            }
                            break;
                        case "*":
                        case "/":
                            if (operators.peek().equals("*") || operators.peek().equals("/")) {
                                nums.offer(operators.pop());
                            }
                            break;
                        case "(":
                            break;
                        case ")":
                            while (!operators.peek().equals("(")) {
                                nums.offer(operators.pop());
                            }
                            operators.pop(); // remove (
                            continue;
                    }
                    operators.push(s);
                }
            }
        }


        while (!nums.isEmpty()) {
            System.out.print(nums.pop() + " ");
        }

        while (!operators.isEmpty()) {
            System.out.print(operators.pop() + " ");

        }
    }
}
