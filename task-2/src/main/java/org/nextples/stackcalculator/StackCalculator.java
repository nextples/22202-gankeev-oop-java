package org.nextples.stackcalculator;

import org.nextples.stackcalculator.command.*;
import org.nextples.stackcalculator.creator.*;
import org.nextples.stackcalculator.command.CommandValidator;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class StackCalculator {
    public static void executeFromFile(String path) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(path));
        } catch (FileNotFoundException e) {
            System.err.println("Invalid input file was passed");
            System.exit(1);
        }
        String currentLine = null;
        try {
            currentLine = bufferedReader.readLine();
        } catch (IOException e) {
            System.err.println("Problems with reading the file");
            System.exit(1);
        }

        ArrayList<String> commandLines = new ArrayList<>();
        while (currentLine != null) {
            if (CommandValidator.isValid(currentLine) && !CommandValidator.isComment(currentLine)) {
                commandLines.add(currentLine);
            }
            if (!CommandValidator.isValid(currentLine)) {
                System.err.println("An unknown command has been detected:\n" + currentLine);
                System.exit(1);
            }
            try {
                currentLine = bufferedReader.readLine();
            } catch (IOException e) {
                System.err.println("Problems with reading the file");
                System.exit(1);
            }
        }


        ExecutionContext context = ExecutionContext.init();

        for (String commandLine : commandLines) {
            String commandName = commandLine.split(" ")[0];
            String args = commandLine.replace(commandName, "");

            String commandCreatorName = NameProcessor.getCommandCreatorName(commandName);

            Class<?> commandCreatorClass = Class.forName(commandCreatorName);
            Object commandCreator = commandCreatorClass.newInstance();

            Command command = ((CommandCreator)commandCreator).create();
            if (args.isEmpty()) {
                ((NonParameterCommand) command).execute(context);
            }
            else {
                ((ParameterCommand) command).execute(args, context);
            }
        }
    }

    public static void executeFromCommandLine() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        System.out.println("\nEnter \"EXIT\" to exit the job");
        Scanner input = new Scanner(System.in);
        String line = input.nextLine();

        ExecutionContext context = ExecutionContext.init();
        while (!Objects.equals(line, "EXIT")) {
            if (CommandValidator.isValid(line) && !CommandValidator.isComment(line)) {

                String commandName = line.split(" ")[0];
                String args = line.replace(commandName, "");

                String commandCreatorName = NameProcessor.getCommandCreatorName(commandName);

                Class<?> commandCreatorClass = Class.forName(commandCreatorName);
                Object commandCreator = commandCreatorClass.newInstance();

                Command command = ((CommandCreator) commandCreator).create();
                if (args.isEmpty()) {
                    ((NonParameterCommand) command).execute(context);
                } else {
                    ((ParameterCommand) command).execute(args, context);
                }
            }
            if (!CommandValidator.isValid(line)) {
                System.err.println("An unknown command has been detected:\n" + line);
            }


            line = input.nextLine();
        }
    }
}
