package org.nextples;

import org.nextples.stackcalculator.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        if (args.length > 1) {
            System.out.println("only one file needs to be transferred");
        }
        else if (args.length == 1) {
            StackCalculator.executeFromFile(args[0]);
        }
        else {
            StackCalculator.executeFromCommandLine();
        }
    }
}