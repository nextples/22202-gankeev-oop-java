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

}
