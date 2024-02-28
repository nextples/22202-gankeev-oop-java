package org.nextples.stackcalculator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Arrays;
import java.util.List;

public class StackCalculator {
    private static final Logger logger = LoggerFactory.getLogger(StackCalculator.class);
    private ExecutionContext context;
    private final CommandFactory factory;

    public StackCalculator(CommandFactory factory) {
        this.context = new ExecutionContext();
        this.factory = factory;
    }

    public void executeCommand(String commandLine) throws IllegalCommandNameException, IllegalAccessException {
        Command command = factory.createCommand(getCommandName(commandLine));

        if (command instanceof ParameterCommand) {
            List<String> args = getArgs(commandLine);
            ((ParameterCommand)command).execute(args, context);
        }
        if (command instanceof NonParameterCommand) {
            ((NonParameterCommand) command).execute(context);
        }
    }

    private String getCommandName(String commandLine) {
        return commandLine.split(" ")[0];
    }

    private List<String> getArgs(String commandLine) throws IllegalArgumentException {
        String commandName = getCommandName(commandLine);
        String args = commandLine.replace(commandName, "");
        String[] parsedArgs = args.split(" ");
        List<String> argsList = Arrays.asList(parsedArgs);
        if (argsList.isEmpty()) {
            logger.error("Command {} received empty arguments", commandName);
            throw new IllegalArgumentException("Command " + commandName + "received empty arguments");
        }
        argsList = argsList.subList(1, argsList.size());
        return argsList;
    }
}
