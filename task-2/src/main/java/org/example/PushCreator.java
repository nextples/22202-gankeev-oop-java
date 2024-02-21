package org.example;

public class PushCreator implements CommandCreator {

    @Override
    public Command create() {
        return new Push();
    }
}
