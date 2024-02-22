package org.nextples.stackcalculator.command;

import org.nextples.stackcalculator.ExecutionContext;

public class Plus implements NonParameterCommand {

    @Override
    public void execute(ExecutionContext context) {
        double arg2 = context.stackPeek();
        context.stackPop();
        double arg1 = context.stackPeek();
        context.stackPop();
        double result = arg1 + arg2;
        context.stackPush(result);
    }
}
