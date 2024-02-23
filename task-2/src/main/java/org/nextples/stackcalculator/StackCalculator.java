package org.nextples.stackcalculator;

import org.nextples.stackcalculator.command.*;
import org.nextples.stackcalculator.creator.*;
import org.nextples.stackcalculator.exceptions.InvalidArgumentException;
import org.nextples.stackcalculator.exceptions.InvalidParameterNameException;

import java.util.EmptyStackException;

public class StackCalculator {
//    public static void executeFromFile(String path) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
//        BufferedReader bufferedReader = null;
//        String commandLine = null;
//        try {
//            bufferedReader = new BufferedReader(new FileReader(path));
//            commandLine = bufferedReader.readLine();
//        }
//        catch (FileNotFoundException e) {
//            System.err.println("The file <<" + path + ">> was not found.");
//            System.exit(1);
//        }
//        catch (IOException e) {
//            System.err.println("The file <<" + path + ">> can not be read.");
//            System.exit(1);
//        }
//
//        ExecutionContext context = ExecutionContext.init();
////        ArrayList<String> commandLines = new ArrayList<>();
//        while (commandLine != null) {
////            try {
//            if (CommandValidator.isValid(commandLine) && !CommandValidator.isComment(commandLine)) {
//                Command command = getCommandByLine(commandLine);
//                String args = getArgsByLine(commandLine);
//                executeCommand(command, args, context);
//            }
//            else if (!CommandValidator.isValid(commandLine)) {
//                System.err.println("An unknown command <<" + commandLine + ">> in <<" + path + ">>\nProgram has been terminated");
//                System.exit(1);
//            }
//            try {
//                commandLine = bufferedReader.readLine();
//            }
//            catch (IOException e) {
//                System.err.println("The file <<" + path + ">> can not be read.");
//                System.exit(1);
//            }
////            }
////            catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
////                System.err.println("An unknown command <<" + commandLine + ">> in <<" + path + ">>");
////            }
//        }
//    }

//    public static void executeFromCommandLine() {
//        System.out.println("\nEnter \"EXIT\" to exit the job");
//        Scanner input = new Scanner(System.in);
//        String line = input.nextLine();
//
//        ExecutionContext context = ExecutionContext.init();
//        while (!Objects.equals(line, "EXIT")) {
//            if (CommandValidator.isValid(line) && !CommandValidator.isComment(line)) {
//                try {
//                    String commandName = line.split(" ")[0];
//                    String args = line.replace(commandName, "");
//
//                    String commandCreatorName = NameProcessor.getCommandCreatorName(commandName);
//
//                    Class<?> commandCreatorClass = Class.forName(commandCreatorName);
//                    Object commandCreator = commandCreatorClass.newInstance();
//
//                    Command command = ((CommandCreator) commandCreator).create();
//                    if (args.isEmpty()) {
//                        ((NonParameterCommand) command).execute(context);
//                    }
//                    else {
//                        ((ParameterCommand) command).execute(args, context);
//                    }
//                }
//                catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
//                    System.err.println("bad input");
//                }
//                catch (EmptyStackException e) {
//                    System.err.println("The command <<" + line + ">> cannot be executed. " +
//                            "There is a shortage of arguments in the stack or the stack is empty. The command was skipped");
//                }
//            }
//            if (!CommandValidator.isValid(line)) {
//                System.err.println("An unknown command <<" + line + ">>");
//            }
//            line = input.nextLine();
//        }
//    }

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
