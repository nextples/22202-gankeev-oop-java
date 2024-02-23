package org.nextples.stackcalculator;

import org.nextples.stackcalculator.command.*;
import org.nextples.stackcalculator.creator.*;
import org.nextples.stackcalculator.exceptions.InvalidArgumentException;
import org.nextples.stackcalculator.exceptions.InvalidParameterNameException;
import java.util.EmptyStackException;

public class StackCalculator {
    public static Command getCommandByLine(String commandLine) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        String commandName = commandLine.split(" ")[0];
        String commandCreatorName = NameProcessor.getCommandCreatorName(commandName);
        Class<?> commandCreatorClass = Class.forName(commandCreatorName);
        Object commandCreator = commandCreatorClass.newInstance();
        Command command = ((CommandCreator) commandCreator).create();
        return command;
    }

    public static String getArgsByLine(String commandLine) {
        String commandName = commandLine.split(" ")[0];
        String args = commandLine.replace(commandName, "");
        return args;
    }

    public static void executeCommand(ParameterCommand command, String args, ExecutionContext context) throws InvalidArgumentException, InvalidParameterNameException, EmptyStackException {
        command.execute(args, context);
    }

    public static void executeCommand(NonParameterCommand command, ExecutionContext context) throws EmptyStackException{
        command.execute(context);
    }
}
