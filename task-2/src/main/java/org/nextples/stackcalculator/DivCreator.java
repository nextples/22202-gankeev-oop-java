package org.nextples.stackcalculator;

public class DivCreator implements CommandCreator {

    @Override
    public Command create() {
        return new Div();
    }
}
