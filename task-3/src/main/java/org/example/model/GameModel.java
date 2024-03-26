package org.example.model;

import org.example.service.Observer;

import java.util.ArrayList;

public class GameModel {
//    private ArrayList<Observer> observers = new ArrayList<Observer>();

    private final Field playerField;
    private Field computerField;

    public GameModel(int fieldSize) {
        playerField = new Field(fieldSize);
//        computerField = new Field(fieldLength, fieldHeight, shipNum);

    }

    public Field getPlayerField() {
        return playerField;
    }



//    public void addSubscriber(Observer s) {
//        observers.add(s);
//        s.update();
//    }
//
//    public void removeSubscriber(Observer o) {
//        observers.remove(o);
//    }
//
//    public void updateSubscribers() {
//        int index = 0;
//        while (index < observers.size()) {
//            observers.get(index).update();
//            index++;
//        }
//    }

}
