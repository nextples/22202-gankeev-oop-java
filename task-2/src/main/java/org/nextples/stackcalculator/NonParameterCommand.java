package org.nextples.stackcalculator;

public interface NonParameterCommand extends Command{
    void execute(ExecutionContext context) throws IllegalAccessException;
}
