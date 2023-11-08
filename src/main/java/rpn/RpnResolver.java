package rpn;

import rpn.operations.*;

import java.util.*;
import java.util.stream.Collectors;

public class RpnResolver {

    public static Integer resolve(String input) {
        List<String> tokens = Arrays.stream(
                input.split(" "))
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toList()
        );

        Stack<Integer> numbers = new Stack<>();

        for (String token : tokens) {
            try {
                Integer parsedNumber = Integer.valueOf(token);
                numbers.push(parsedNumber);
            } catch (NumberFormatException e) {
                if (numbers.isEmpty()) {
                    throw new IllegalArgumentException("Invalid expression");
                }
                computeOperation(numbers, token);
            }
        }

        return numbers.pop();
    }

    private static void computeOperation(Stack<Integer> stack, String operator) {
        OperationStrategy operationStrategy;

        switch(operator) {
            case "sqrt":
                operationStrategy = new SqrtOperationStrategy();
                break;
            case "max":
                operationStrategy = new MaxOperationStrategy();
                break;
            default:
                operationStrategy = handleBasicOperators(operator, stack);
        }
        stack.push(operationStrategy.computeOperation(stack));
    }

    private static OperationStrategy handleBasicOperators(String operator, Stack<Integer> stack) {
        if(stack.size() != 2) {
            throw new IllegalArgumentException("Not enough operands");
        }
        switch (operator) {
            case "+":
                return new PlusOperationStrategy();
            case "-":
                return new MinusOperationStrategy();
            case "*":
                return new TimesOperationStrategy();
            default:
                throw new IllegalArgumentException("Unknown operator: " + operator);
        }
    }

}