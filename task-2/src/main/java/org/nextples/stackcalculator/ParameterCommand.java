package org.nextples.stackcalculator;

public interface ParameterCommand extends Command {
    void execute(String args, ExecutionContext context) throws InvalidArgumentException, InvalidParameterNameException;
}
