package org.nextples.stackcalculator.command;

import org.nextples.stackcalculator.ExecutionContext;
import java.util.EmptyStackException;

public class Pop implements NonParameterCommand {

    @Override
    public void execute(ExecutionContext context) throws EmptyStackException {
        context.stackPop();
    }
}
