package org.nextples.stackcalculator;

import static java.lang.Math.sqrt;

public class Sqrt implements NonParameterCommand {

    @Override
    public void execute(ExecutionContext context) throws ArithmeticException, IllegalAccessException {
        if (context.getStack().empty()) {
            throw new IllegalAccessException("Attempt to access an element from an empty stack");
        }
        double arg = (double) context.getStack().peek();
        context.getStack().pop();

        if (arg < 0) {
            throw new ArithmeticException("Invalid extraction of the square root of " + arg);
        }
        else {
            double result = sqrt(arg);
            context.getStack().push(result);
        }
    }
}
