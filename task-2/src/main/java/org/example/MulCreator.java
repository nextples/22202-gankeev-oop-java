package org.example;

public class MulCreator implements CommandCreator {

    @Override
    public Command create() {
        return new Mul();
    }
}
