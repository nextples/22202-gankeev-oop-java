package org.nextples.stackcalculator;

public class PlusCreator implements CommandCreator {

    @Override
    public Command create() {
        return new Plus();
    }
}
