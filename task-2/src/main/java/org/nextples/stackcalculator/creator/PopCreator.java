package org.nextples.stackcalculator.creator;

import org.nextples.stackcalculator.command.*;

public class PopCreator implements CommandCreator {

    @Override
    public Command create() {
        return new Pop();
    }
}
