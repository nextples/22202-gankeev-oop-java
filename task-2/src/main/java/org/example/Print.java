package org.example;

public class Print implements NonParameterCommand {
    @Override
    public void execute(ExecutionContext context) {
        System.out.println(context.stackPeek());
    }



}
