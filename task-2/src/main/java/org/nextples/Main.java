package org.nextples;

import org.nextples.stackcalculator.*;

import java.io.*;
import java.util.EmptyStackException;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner;
        if (args.length == 0) {
            scanner = new Scanner(System.in);
        }
        else {
            try {
                scanner = new Scanner(new FileInputStream(args[0]));
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }




//    public static void main(String[] args) {
//        try {
//            if (args.length > 1) {
//                System.out.println("Incorrect number of arguments. Pass only one file");
//            }
//            else if (args.length == 1) {
//                readFromFile(args[0]);
//            }
//            else {
//                readFromCommandLine();
//            }
//        }
//        catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
//            System.err.println("the file " + args[0] + " contains an unknown command. " +
//                        "It is possible that the command name does not match the class name (if the command is external)");
//        }
//    }

    private static void readFromFile(String path) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        BufferedReader bufferedReader = null;
        String commandLine = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(path));
            commandLine = bufferedReader.readLine();
        } catch (FileNotFoundException e) {
            System.err.println("The file <<" + path + ">> was not found.");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("The file <<" + path + ">> can not be read.");
            System.exit(1);
        }

        ExecutionContext context = ExecutionContext.init();
        while (commandLine != null) {
            executeStringCommand(commandLine, context);

            try {
                commandLine = bufferedReader.readLine();
            }
            catch (IOException e) {
                System.err.println("The file <<" + path + ">> can not be read.");
                System.exit(1);
            }
        }
    }

    private static void readFromCommandLine() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        System.out.println("\nEnter \"EXIT\" to exit the job");
        Scanner input = new Scanner(System.in);
        String commandLine = input.nextLine();
        ExecutionContext context = ExecutionContext.init();

        while (!Objects.equals(commandLine, "EXIT")) {
            executeStringCommand(commandLine, context);
            commandLine = input.nextLine();
        }
    }

    private static void executeStringCommand(String commandLine, ExecutionContext context) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        try {
            if (CommandValidator.isValid(commandLine) && !CommandValidator.isComment(commandLine)) {
                Command command = StackCalculator.getCommandByLine(commandLine);
                String args = StackCalculator.getArgsByLine(commandLine);
                if (command instanceof ParameterCommand) {
                    StackCalculator.executeCommand((ParameterCommand) command, args, context);
                } else if (command instanceof NonParameterCommand) {
                    StackCalculator.executeCommand((NonParameterCommand) command, context);
                }
            }
            else if (!CommandValidator.isValid(commandLine)) {
                System.err.println("An unknown command <<" + commandLine + ">>\nCommand was skipped\n");
            }
        }
        catch (InvalidArgumentException | InvalidParameterNameException e) {
            System.err.println(e.getMessage());
            System.err.println("Command was skipped\n");
        }
        catch (EmptyStackException e) {
            System.err.println("The problem of extracting items from the stack. There are not enough elements in the stack or the stack is empty");
            System.err.println("Command was skipped\n");
        }
    }
}