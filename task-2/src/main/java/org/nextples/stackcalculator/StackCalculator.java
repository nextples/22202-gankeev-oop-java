package org.nextples.stackcalculator;

import org.nextples.stackcalculator.command.*;
import org.nextples.stackcalculator.creator.*;
import org.nextples.stackcalculator.command.CommandValidator;
import org.nextples.stackcalculator.exceptions.InvalidCommandException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class StackCalculator {
    public static void executeFromFile(String path) throws InvalidCommandException {
        BufferedReader bufferedReader = null;
        String currentLine = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(path));
            currentLine = bufferedReader.readLine();
        }
        catch (FileNotFoundException e) {
            System.err.println("The file <<" + path + ">> was not found.");
            System.exit(1);
        }
        catch (IOException e) {
            System.err.println("The file <<" + path + ">> can not be read.");
            System.exit(1);
        }


        ArrayList<String> commandLines = new ArrayList<>();
        while (currentLine != null) {
            if (CommandValidator.isValid(currentLine) && !CommandValidator.isComment(currentLine)) {
                commandLines.add(currentLine);
            }
            if (!CommandValidator.isValid(currentLine)) {
                throw new InvalidCommandException("An unknown command <<" + currentLine + ">> in <<" + path + ">>");

            }
            try {
                currentLine = bufferedReader.readLine();
            } catch (IOException e) {
                System.err.println("The file <<" + path + ">> can not be read.");
                System.exit(1);
            }
        }


        ExecutionContext context = ExecutionContext.init();
        for (String commandLine : commandLines) {
            try {
                String commandName = commandLine.split(" ")[0];
                String args = commandLine.replace(commandName, "");

                String commandCreatorName = NameProcessor.getCommandCreatorName(commandName);

                Class<?> commandCreatorClass = Class.forName(commandCreatorName);
                Object commandCreator = commandCreatorClass.newInstance();

                Command command = ((CommandCreator) commandCreator).create();
                if (args.isEmpty()) {
                    ((NonParameterCommand) command).execute(context);
                }
                else {
                    ((ParameterCommand) command).execute(args, context);
                }
            }
            catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
                System.err.println("bad input");
            }
        }
    }

    public static void executeFromCommandLine() {
        System.out.println("\nEnter \"EXIT\" to exit the job");
        Scanner input = new Scanner(System.in);
        String line = input.nextLine();

        ExecutionContext context = ExecutionContext.init();
        while (!Objects.equals(line, "EXIT")) {
            if (CommandValidator.isValid(line) && !CommandValidator.isComment(line)) {
                try {
                    String commandName = line.split(" ")[0];
                    String args = line.replace(commandName, "");

                    String commandCreatorName = NameProcessor.getCommandCreatorName(commandName);

                    Class<?> commandCreatorClass = Class.forName(commandCreatorName);
                    Object commandCreator = commandCreatorClass.newInstance();

                    Command command = ((CommandCreator) commandCreator).create();
                    if (args.isEmpty()) {
                        ((NonParameterCommand) command).execute(context);
                    }
                    else {
                        ((ParameterCommand) command).execute(args, context);
                    }
                }
                catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
                    System.err.println("bad input");
                }
            }
            if (!CommandValidator.isValid(line)) {
                System.err.println("An unknown command <<" + line + ">>");
            }
            line = input.nextLine();
        }
    }
}
