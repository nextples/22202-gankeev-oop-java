package org.nextples.stackcalculator;

import java.util.EmptyStackException;

public class Print implements NonParameterCommand {

    @Override
    public void execute(ExecutionContext context) throws IllegalAccessException {
        if (context.getStack().empty()) {
            throw new IllegalAccessException("Attempt to print an element from the empty stack");
        }

        System.out.println(context.getStack().peek());
    }
}
