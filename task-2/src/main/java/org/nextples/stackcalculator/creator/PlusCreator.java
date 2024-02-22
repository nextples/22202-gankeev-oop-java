package org.nextples.stackcalculator.creator;

import org.nextples.stackcalculator.command.*;

public class PlusCreator implements CommandCreator {

    @Override
    public Command create() {
        return new Plus();
    }
}
