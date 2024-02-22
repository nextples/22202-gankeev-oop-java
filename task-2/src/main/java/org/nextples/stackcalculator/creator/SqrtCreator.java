package org.nextples.stackcalculator.creator;

import org.nextples.stackcalculator.command.*;

public class SqrtCreator implements CommandCreator {

    @Override
    public Command create() {
        return new Sqrt();
    }
}