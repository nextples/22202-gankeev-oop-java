package org.nextples.stackcalculator.command;

import org.nextples.stackcalculator.ExecutionContext;
import org.nextples.stackcalculator.exceptions.InvalidArgumentException;
import org.nextples.stackcalculator.exceptions.InvalidParameterNameException;

public interface ParameterCommand extends Command {
    void execute(String args, ExecutionContext context) throws InvalidArgumentException, InvalidParameterNameException;
}
