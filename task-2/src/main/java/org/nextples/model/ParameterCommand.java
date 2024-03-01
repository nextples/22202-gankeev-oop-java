package org.nextples.stackcalculator;

import java.util.List;

public interface ParameterCommand extends Command {
    void execute(List<String> args, ExecutionContext context) throws IllegalArgumentException;
}
