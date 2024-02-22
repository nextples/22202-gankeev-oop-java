package org.nextples.stackcalculator.creator;

import org.nextples.stackcalculator.command.*;

public class SubCreator implements CommandCreator {

    @Override
    public Command create() {
        return new Sub();
    }
}
