package org.nextples.error;

import org.nextples.error.CommandException;

public class IllegalCommandNameException extends CommandException {
    public IllegalCommandNameException(String message) {
        super(message);
    }
}
