import java.util.*;
import java.util.stream.Collectors;

public class RpnResolver {
    public static void main(String[] args) {

        System.out.println("Enter RPN expression: ");
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int result = resolve(input);

    }

    public static Integer resolve(String input) {
        List<String> tokens = Arrays.asList(input.split(" "));

        Stack<Integer> numbers = new Stack<>();

        if(tokens.size() < 3 && !tokens.contains("sqrt")) {
            throw new IllegalArgumentException("Not enough operands");
        }

        for (String token : tokens) {
            try {
                Integer parsedNumber = Integer.valueOf(token);
                numbers.push(parsedNumber);
            } catch (NumberFormatException e) {
                if (numbers.size() != 2 && !tokens.contains("sqrt")) {
                    throw new IllegalArgumentException("Invalid expression");
                }
                computeOperation(numbers, token);
            }
        }

        return numbers.pop();
    }

    private static void computeOperation(Stack<Integer> stack, String operator) {
        Integer a = stack.pop();
        Integer b = stack.pop();
        switch (operator) {
            case "+":
                stack.push(a + b);
                break;
            case "-":
                stack.push(b - a);
                break;
            case "*":
                stack.push(a * b);
                break;
            default:
                throw new IllegalArgumentException("Unknown operator: " + operator);
        }
    }

}