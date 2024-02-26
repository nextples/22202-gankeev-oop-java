package org.nextples.stackcalculator;

public class Div implements NonParameterCommand {

    @Override
    public void execute(ExecutionContext context) throws ArithmeticException, IllegalAccessException {
        if (context.getStack().empty()) {
            throw new IllegalAccessException("Attempt to access an element from an empty stack");
        }
        double arg2 = (double) context.getStack().peek();
        context.getStack().pop();

        if (context.getStack().empty()) {
            throw new IllegalAccessException("Attempt to access an element from an empty stack");
        }
        double arg1 = (double) context.getStack().peek();
        context.getStack().pop();

        if (arg2 == 0) {
            throw new ArithmeticException("Invalid division by zero: " + arg1 + " / " + arg2);
        }
        double result = arg1 / arg2;
        context.getStack().push(result);
    }
}
