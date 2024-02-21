package org.example;

public class PlusCreator implements CommandCreator {

    @Override
    public Command create() {
        return new Plus();
    }
}
