package org.nextples.stackcalculator.creator;

import org.nextples.stackcalculator.command.*;

public class DefineCreator implements CommandCreator {

    @Override
    public Command create() {
        return new Define();
    }
}
