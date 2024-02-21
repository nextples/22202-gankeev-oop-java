package org.example;

public class SubCreator implements CommandCreator {

    @Override
    public Command create() {
        return new Sub();
    }
}
