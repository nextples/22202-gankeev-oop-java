package org.nextples.stackcalculator;

import org.nextples.CommandFactory;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

public class StackCalculator {
    private ExecutionContext context;
    private final CommandFactory factory;

    public StackCalculator(CommandFactory factory) {
        this.context = new ExecutionContext();
        this.factory = factory;
    }

    public void executeCommand(String commandLine) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, IllegalArgumentException {
        Command command = factory.createCommand(getCommandName(commandLine));

        if (command instanceof ParameterCommand) {
            List<String> args = getArgs(commandLine);
            ((ParameterCommand)command).execute(args, context);
        }
        if (command instanceof NonParameterCommand) {
            ((NonParameterCommand) command).execute(context);
        }

//        List<String> args = getArgs(commandLine);
//        if (args.isEmpty()) {
//            ((NonParameterCommand)command).execute(context);
//        }
//        else {
//            ((ParameterCommand)command).execute(args, context);
//        }
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
            throw new IllegalArgumentException("Command " + commandLine + "received incorrect arguments\n");
        }
        argsList = argsList.subList(1, argsList.size());
        return argsList;
    }
}
