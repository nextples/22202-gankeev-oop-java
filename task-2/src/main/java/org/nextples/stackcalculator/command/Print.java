package org.nextples.stackcalculator.command;

import org.nextples.stackcalculator.ExecutionContext;

import java.util.EmptyStackException;

public class Print implements NonParameterCommand {
    @Override
    public void execute(ExecutionContext context) throws EmptyStackException {
        System.out.println(context.stackPeek());
    }



}
