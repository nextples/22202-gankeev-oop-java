package org.nextples.stackcalculator;

import java.util.EmptyStackException;

public class Print implements NonParameterCommand {

    @Override
    public void execute(ExecutionContext context) throws EmptyStackException {
        System.out.println(context.stackPeek());
    }
}
