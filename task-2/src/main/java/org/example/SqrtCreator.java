package org.example;

public class SqrtCreator implements CommandCreator {

    @Override
    public Command create() {
        return new Sqrt();
    }
}
