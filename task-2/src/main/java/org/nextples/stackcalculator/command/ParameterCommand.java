package org.nextples.stackcalculator.command;

import org.nextples.stackcalculator.ExecutionContext;

public interface ParameterCommand extends Command {
    void execute(String args, ExecutionContext context);
}
