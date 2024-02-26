package org.nextples.stackcalculator;

public class Sub implements NonParameterCommand {

    @Override
    public void execute(ExecutionContext context) throws IllegalAccessException {
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

        double result = arg1 - arg2;
        context.getStack().push(result);
    }
}
