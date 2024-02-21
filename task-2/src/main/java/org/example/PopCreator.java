package org.example;

public class PopCreator implements CommandCreator {

    @Override
    public Command create() {
        return new Pop();
    }
}
