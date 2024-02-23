package org.nextples.stackcalculator;

public class DefineCreator implements CommandCreator {

    @Override
    public Command create() {
        return new Define();
    }
}
