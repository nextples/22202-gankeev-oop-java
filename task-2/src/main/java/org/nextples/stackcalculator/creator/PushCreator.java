package org.nextples.stackcalculator.creator;

import org.nextples.stackcalculator.command.*;

public class PushCreator implements CommandCreator {

    @Override
    public Command create() {
        return new Push();
    }
}
