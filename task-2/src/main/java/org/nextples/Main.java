package org.nextples;

import org.nextples.stackcalculator.*;
import java.io.*;
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
                throw new RuntimeException(e.getLocalizedMessage());
            }
        }

        CommandFactory factory;
        factory = new CommandFactory();

        StackCalculator calculator = new StackCalculator(factory);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.charAt(0) == '#') {
                continue;
            }

            try {
                calculator.executeCommand(line);
            }
            catch (IllegalArgumentException e) {
                throw new RuntimeException(e.getMessage());
            }
            catch (Exception e) {
                throw new RuntimeException("Invalid command name: " + line);
            }
        }
    }
}