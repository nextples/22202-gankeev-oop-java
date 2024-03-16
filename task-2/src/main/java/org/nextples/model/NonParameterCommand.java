package org.nextples.model;

public interface NonParameterCommand extends Command {
    void execute(ExecutionContext context) throws IllegalAccessException, ArithmeticException;
}
