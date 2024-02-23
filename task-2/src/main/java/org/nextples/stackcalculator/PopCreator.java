package org.nextples.stackcalculator;

public class PopCreator implements CommandCreator {

    @Override
    public Command create() {
        return new Pop();
    }
}
