package rpn.operations;

import rpn.OperationStrategy;

import java.util.Stack;

public class PlusOperationStrategy implements OperationStrategy {
    @Override
    public Integer computeOperation(Stack<Integer> operands) {
        return operands.pop() + operands.pop();
    }
}
