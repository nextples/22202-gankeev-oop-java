package org.nextples.stackcalculator.creator;

import org.nextples.stackcalculator.command.*;

public class PrintCreator implements CommandCreator {

    @Override
    public Command create() {
        return new Print();
    }
}
