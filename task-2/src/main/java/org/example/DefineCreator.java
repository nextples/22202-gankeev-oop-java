package org.example;

public class DefineCreator implements CommandCreator {

    @Override
    public Command create() {
        return new Define();
    }
}
