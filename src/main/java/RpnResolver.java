import java.util.Scanner;
import java.util.Stack;

import static java.lang.Integer.parseInt;

public class RpnResolver {
    public static void main(String[] args) {

        System.out.println("Enter RPN expression: ");
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int result = resolve(input);

    }

    public static Integer resolve(String input) {
        String[] tokens = input.split(" ");

        Stack<Integer> numbers = new Stack<>();

        if(tokens.length < 3) {
            throw new IllegalArgumentException("Not enough operands");
        }
        
        for (String token : tokens) {
            try {
                Integer parsedNumber = Integer.valueOf(token);
                numbers.push(parsedNumber);
            } catch (NumberFormatException e) {
                if (numbers.size() != 2) {
                    throw new IllegalArgumentException("Invalid expression");
                }
                switch (token) {
                    case "+":
                        Integer a = numbers.pop();
                        Integer b = numbers.pop();
                        numbers.push(a + b);
                        break;
                    case "-":
                        Integer a1 = numbers.pop();
                        Integer b1 = numbers.pop();
                        numbers.push(b1 - a1);
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown operator: " + token);
                }
            }
        }

        return numbers.pop();
    }

    private Integer parseToken(String token) {
        try {
            return Integer.valueOf(token);
        } catch (NumberFormatException e) {
            return null;
        }
    }

}