package org.nextples.stackcalculator;

public class IllegalCommandNameException extends CommandException {
    public IllegalCommandNameException(String message) {
        super(message);
    }
}
