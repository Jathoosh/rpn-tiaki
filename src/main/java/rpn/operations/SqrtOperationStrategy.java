package rpn.operations;

import rpn.OperationStrategy;

import java.util.Stack;

public class SqrtOperationStrategy implements OperationStrategy {
    @Override
    public Integer computeOperation(Stack<Integer> operands) {
        return (int) Math.sqrt(operands.pop());
    }
}
