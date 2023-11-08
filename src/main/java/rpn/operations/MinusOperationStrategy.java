package rpn.operations;

import rpn.OperationStrategy;

import java.util.Stack;

public class MinusOperationStrategy implements OperationStrategy {

    @Override
    public Integer computeOperation(Stack<Integer> operands) {
        Integer a = operands.pop();
        Integer b = operands.pop();

        return b - a;
    }
}
