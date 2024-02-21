package org.example;

public class PrintCreator implements CommandCreator {

    @Override
    public Command create() {
        return new Print();
    }


}
