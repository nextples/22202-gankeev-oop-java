package org.nextples.stackcalculator.command;

import org.nextples.stackcalculator.ExecutionContext;

public class Print implements NonParameterCommand {
    @Override
    public void execute(ExecutionContext context) {
        System.out.println(context.stackPeek());
    }



}
