package org.nextples.stackcalculator.creator;

import org.nextples.stackcalculator.command.*;

public class MulCreator implements CommandCreator {

    @Override
    public Command create() {
        return new Mul();
    }
}
