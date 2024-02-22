package org.nextples.stackcalculator.command;

import org.nextples.stackcalculator.ExecutionContext;

public interface NonParameterCommand extends Command{
    void execute(ExecutionContext context);
}
