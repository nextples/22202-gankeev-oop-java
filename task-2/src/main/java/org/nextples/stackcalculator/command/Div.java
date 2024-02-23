package org.nextples.stackcalculator.command;

import org.nextples.stackcalculator.ExecutionContext;

import java.util.EmptyStackException;

public class Div implements NonParameterCommand {

    @Override
    public void execute(ExecutionContext context) throws ArithmeticException, EmptyStackException {
        double arg2 = context.stackPeek();
        context.stackPop();
        double arg1 = context.stackPeek();
        context.stackPop();
        if (arg2 == 0) {
            throw new ArithmeticException("Invalid division by zero: " + arg1 + " / " + arg2);
        }
        double result = arg1 / arg2;
        context.stackPush(result);
    }
}
