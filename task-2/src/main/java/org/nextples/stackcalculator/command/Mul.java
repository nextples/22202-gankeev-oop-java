package org.nextples.stackcalculator.command;

import org.nextples.stackcalculator.ExecutionContext;
import java.util.EmptyStackException;

public class Mul implements NonParameterCommand {

    @Override
    public void execute(ExecutionContext context) throws EmptyStackException {
        double arg2 = context.stackPeek();
        context.stackPop();
        double arg1 = context.stackPeek();
        context.stackPop();
        double result = arg1 * arg2;
        context.stackPush(result);
    }
}
