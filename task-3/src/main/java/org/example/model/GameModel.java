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

}
