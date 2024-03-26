package org.example.model;

import org.example.error.ShipsRandomArrangementException;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Field {
    private final int fieldSize;
//    private int shipNum;
    private final Cell[][] cells;

    /**
     * Map for ships on the field: size-count
     **/
    private final HashMap<Integer, Integer> config = new HashMap<Integer, Integer>();


    public Field(int fieldSize) {
        this.fieldSize = fieldSize;
        cells = new Cell[fieldSize][fieldSize];
        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                cells[i][j] = new Cell(i, j);
            }
        }

        createConfig();
    }

    public void setAllShipsRandomly() throws ShipsRandomArrangementException {
        for (Map.Entry<Integer, Integer> entry : config.entrySet()) {
            int shipSize = entry.getKey();
            int shipNumb = entry.getValue();
            for (int i = 0; i < shipNumb; i++) {
                Ship ship = new Ship(shipSize);
                ship.setCells(cells);
                ship.setFieldSize(fieldSize);

                int iterCounter = 0;
                while (true) {
                    iterCounter++;

                    Random rand = new Random();
                    int x = rand.nextInt(0, fieldSize - 1);
                    int y = rand.nextInt(0, fieldSize - 1);
                    int orientation = rand.nextInt(1, 3);
                    if (ship.setShip(x, y, orientation)) {
                        updateCheckedCells();
                        break;
                    }

                    if ((iterCounter % (fieldSize * fieldSize)) == 0) {     // check once per fieldSize^2 times
                        if (checkInfinityCycle()) {
                            throw new ShipsRandomArrangementException("The error of placing ships in a random order: there are no cells available for placement");
                        }
                    }
                }
            }
        }
    }

    private boolean checkInfinityCycle() {
        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                if (!cells[i][j].isRandomlyChecked()) {
                    return false;
                }
            }
        }
        return true;
    }

    private void updateCheckedCells() {
        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                cells[i][j].setRandomlyChecked(false);
            }
        }
    }

    public Cell[][] getCells() {
        return cells;
    }

    public int getFieldSize() {
        return fieldSize;
    }

    public HashMap<Integer, Integer> getConfig() {
        return config;
    }

    public void clearPickedCells() {
        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                cells[i][j].setPicked(false);
            }
        }
    }

    private void createConfig() {
        switch (fieldSize) {
            case 10:
                config.put(1, 4);
                config.put(2, 3);
                config.put(3, 2);
                config.put(4, 1);
                break;
            case 15:
                config.put(1, 5);
                config.put(2, 4);
                config.put(3, 3);
                config.put(4, 2);
                config.put(5, 1);
                break;
            case 21:
                config.put(1, 6);
                config.put(2, 5);
                config.put(3, 4);
                config.put(4, 3);
                config.put(5, 2);
                config.put(6, 1);;
                break;
            default:
                config.put(1, 4);
                config.put(2, 3);
                config.put(3, 2);
                config.put(4, 1);
                break;
            }
    }

}
