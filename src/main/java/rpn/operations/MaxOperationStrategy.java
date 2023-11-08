package rpn.operations;

import rpn.OperationStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MaxOperationStrategy implements OperationStrategy {
    @Override
    public Integer computeOperation(Stack<Integer> operands) {
        List<Integer> numbers = new ArrayList<>(operands);
        return numbers.stream().max(Integer::compareTo).get();
    }
}
