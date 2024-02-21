package org.example;

public class DivCreator implements CommandCreator {

    @Override
    public Command create() {
        return new Div();
    }
}
