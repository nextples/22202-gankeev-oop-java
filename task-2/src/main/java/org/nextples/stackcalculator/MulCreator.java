package org.nextples.stackcalculator;

public class MulCreator implements CommandCreator {

    @Override
    public Command create() {
        return new Mul();
    }
}
