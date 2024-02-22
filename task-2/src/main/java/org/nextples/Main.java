package org.nextples;

import org.nextples.stackcalculator.*;
import org.nextples.stackcalculator.exceptions.InvalidCommandException;

public class Main {
    public static void main(String[] args) {
        if (args.length > 1) {
            System.out.println("Incorrect number of arguments. Pass only one file");
        }
        else if (args.length == 1) {
            try {
                StackCalculator.executeFromFile(args[0]);
            }
            catch (InvalidCommandException e) {
                System.err.println(e.getMessage());
                System.exit(1);
            }
        }
        else {
            StackCalculator.executeFromCommandLine();
        }
    }
}