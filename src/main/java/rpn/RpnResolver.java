package rpn;

import rpn.operations.MinusOperationStrategy;
import rpn.operations.PlusOperationStrategy;
import rpn.operations.SqrtOperationStrategy;
import rpn.operations.TimesOperationStrategy;

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
        List<String> tokens = Arrays.stream(
                input.split(" "))
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toList()
        );

        Stack<Integer> numbers = new Stack<>();

        if(tokens.size() < 3 && !tokens.contains("sqrt")) {
            throw new IllegalArgumentException("Not enough operands");
        }

        for (String token : tokens) {
            try {
                Integer parsedNumber = Integer.valueOf(token);
                numbers.push(parsedNumber);
            } catch (NumberFormatException e) {
                if (numbers.size() != 2 && !tokens.contains("sqrt") && !tokens.contains("max")) {
                    throw new IllegalArgumentException("Invalid expression");
                }
                computeOperation(numbers, token);
            }
        }

        return numbers.pop();
    }

    private static void computeOperation(Stack<Integer> stack, String operator) {
        OperationStrategy operationStrategy;
        switch (operator) {
            case "+":
                operationStrategy = new PlusOperationStrategy();
                break;
            case "-":
                operationStrategy = new MinusOperationStrategy();
                break;
            case "*":
                operationStrategy = new TimesOperationStrategy();
                break;
            case "sqrt":
                operationStrategy = new SqrtOperationStrategy();
                break;
            default:
                throw new IllegalArgumentException("Unknown operator: " + operator);
        }

        stack.push(operationStrategy.computeOperation(stack));
    }

}