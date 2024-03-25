package org.example.model;

import java.util.ArrayList;

public class GameModel {
    private ArrayList<Subscriber> subscribers = new ArrayList<Subscriber>();

    private final Field playerField;
    private Field computerField;

    public GameModel(int fieldSize) {
        playerField = new Field(fieldSize);
//        computerField = new Field(fieldLength, fieldHeight, shipNum);

    }

    public Field getPlayerField() {
        return playerField;
    }



    public void addSubscriber(Subscriber s) {
        subscribers.add(s);
        s.update();
    }

    public void removeSubscriber(Subscriber o) {
        subscribers.remove(o);
    }

    public void updateSubscribers() {
        int index = 0;
        while (index < subscribers.size()) {
            subscribers.get(index).update();
            index++;
        }
    }

}
