package org.nextples.stackcalculator.command;

import org.nextples.stackcalculator.ExecutionContext;

public class Pop implements NonParameterCommand {

    @Override
    public void execute(ExecutionContext context) {
        context.stackPop();
    }
}
