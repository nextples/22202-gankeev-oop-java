package org.example;

interface ParameterCommand extends Command {
    void execute(String args, ExecutionContext context);
}
