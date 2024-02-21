package org.example;

public class Pop implements NonParameterCommand {

    @Override
    public void execute(ExecutionContext context) {
        context.stackPop();
    }
}
