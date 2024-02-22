package org.nextples.stackcalculator.command;

import org.nextples.stackcalculator.ExecutionContext;

public class Div implements NonParameterCommand {

    @Override
    public void execute(ExecutionContext context) throws ArithmeticException {
        double arg2 = context.stackPeek();
        context.stackPop();
        double arg1 = context.stackPeek();
        context.stackPop();
        if (arg2 == 0) {
            throw new ArithmeticException();
        }
        double result = arg1 / arg2;
        context.stackPush(result);
    }
}
