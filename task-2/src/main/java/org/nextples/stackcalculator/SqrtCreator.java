package org.nextples.stackcalculator;

public class SqrtCreator implements CommandCreator {

    @Override
    public Command create() {
        return new Sqrt();
    }
}
