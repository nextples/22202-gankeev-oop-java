package org.nextples.stackcalculator;

public class PrintCreator implements CommandCreator {

    @Override
    public Command create() {
        return new Print();
    }
}
