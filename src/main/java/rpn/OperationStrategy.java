package rpn;

import java.util.Stack;

/**
 * Contract which defines an operation strategy.
 */
public interface OperationStrategy {

    /**
     * Computes the operation on the given operands.
     * @param operands The operands to compute the operation on.
     * @return The result of the operation.
     */
    Integer computeOperation(Stack<Integer> operands);
}
