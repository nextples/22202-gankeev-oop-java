package org.nextples.stackcalculator.creator;

import org.nextples.stackcalculator.command.*;

public class DivCreator implements CommandCreator {

    @Override
    public Command create() {
        return new Div();
    }
}
