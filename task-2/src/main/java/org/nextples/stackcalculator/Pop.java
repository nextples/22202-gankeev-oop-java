package org.nextples.stackcalculator;


public class Pop implements NonParameterCommand {

    @Override
    public void execute(ExecutionContext context) throws IllegalAccessException {
        if (context.getStack().empty()) {
            throw new IllegalAccessException("Attempt to pop an element from the empty stack");
        }

        context.getStack().pop();
    }
}
