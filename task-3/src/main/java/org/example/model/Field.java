package org.example.model;

import java.util.HashMap;

import static org.example.model.Ship.SHIP_HORIZONTAL;
import static org.example.model.Ship.SHIP_VERTICAL;

public class Field {
    private final int fieldSize;
//    private int shipNum;
    private final Cell[][] cells;

    /**
     * Map for ships on the field: size-count
     **/
    private final HashMap<Integer, Integer> shipConfig = new HashMap<Integer, Integer>();

//    private final HashMap<Integer, Integer> shipNumber

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

    /**
     * @param x X-coordinate of the upper left side of the ship
     * @param y Y-coordinate of the upper left side of the ship
     * @param orientation Vertical or Horizontal orientation of the ship on the field
     *
     * @return returns 1 if ship was successfully set to the place,
     * <p>
     * returns 0 if the installation of the ship in the specified location is unacceptable
     */
    public boolean setShip(Ship ship, int x, int y, int orientation) {
        if (!isAvailablePosition(ship.getSize(), x, y, orientation)) {
            return false;
        }
        if (orientation == SHIP_HORIZONTAL) {
            for (int i = 0; i < ship.getSize(); i++) {
                cells[x + i][y].setShip();
            }
            setBorder(ship, x, y, orientation);
            return true;
        }
        else if (orientation == SHIP_VERTICAL) {
            for (int i = 0; i < ship.getSize(); i++) {
                cells[x][y + i].setShip();
            }
            setBorder(ship, x, y, orientation);
            return true;
        }
        return false;
    }

    private boolean isExistingCell(int x, int y) {
        return  (x >= 0 && x < fieldSize  && y >= 0 && y < fieldSize);
    }

    private void setBorder(Ship ship, int x, int y, int orientation) {
        if (orientation == SHIP_HORIZONTAL) {
            for (int i = -1; i < ship.getSize() + 1; i++) {

                if (isExistingCell(x + i, y - 1)) {
                    cells[x + i][y - 1].setBorder();
                }

                if (isExistingCell(x + i, y) && !cells[x + i][y].containShip()) {
                    cells[x + i][y].setBorder();
                }

                if (isExistingCell(x + i, y + 1)) {
                    cells[x + i][y + 1].setBorder();
                }
                }

        }
        if (orientation == SHIP_VERTICAL) {
            for (int i = -1; i < ship.getSize() + 1; i++) {

                if (isExistingCell(x - 1, y + i)) {
                    cells[x - 1][y + i].setBorder();
                }

                if (isExistingCell(x, y + i) && !cells[x][y + i].containShip()) {
                    cells[x][y + i].setBorder();
                }

                if (isExistingCell(x + 1, y + i)) {
                    cells[x + 1][y + i].setBorder();
                }
            }
        }

    }

//    public void setAllShipsRandomly() throws ShipsRandomArrangementException {
//        for (Map.Entry<Integer, Integer> entry : config.entrySet()) {
//            int shipSize = entry.getKey();
//            int shipNumb = entry.getValue();
//            for (int i = 0; i < shipNumb; i++) {
//                Ship ship = new Ship(shipSize);
//                ship.setCells(cells);
//                ship.setFieldSize(fieldSize);
//
//                int iterCounter = 0;
//                while (true) {
//                    iterCounter++;
//
//                    Random rand = new Random();
//                    int x = rand.nextInt(0, fieldSize - 1);
//                    int y = rand.nextInt(0, fieldSize - 1);
//                    int orientation = rand.nextInt(1, 3);
//                    if (ship.setShip(x, y, orientation)) {
//                        updateCheckedCells();
//                        break;
//                    }
//
//                    if ((iterCounter % (fieldSize * fieldSize)) == 0) {     // check once per fieldSize^2 times
//                        if (checkInfinityCycle()) {
//                            throw new ShipsRandomArrangementException("The error of placing ships in a random order: there are no cells available for placement");
//                        }
//                    }
//                }
//            }
//        }
//    }

    private boolean isAvailablePosition(int shipSize, int x, int y, int orientation) {
        if (orientation == SHIP_HORIZONTAL && x + shipSize > fieldSize) {
            return false;
        }
        if (orientation == SHIP_VERTICAL && y + shipSize >= fieldSize) {
            return false;
        }
        for (int i = 0; i < shipSize; i++) {
            if (orientation == SHIP_HORIZONTAL) {
                if ( !cells[x + i][y].isBorder() && !cells[x + i][y].containShip() ) {
                    return true;
                }
            }
            else {
                if ( !cells[x][y + i].isBorder() && !cells[x][y + i].containShip() ) {
                    return true;
                }
            }
        }
        return false;
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

    public HashMap<Integer, Integer> getShipConfig() {
        return shipConfig;
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
                shipConfig.put(1, 4);
                shipConfig.put(2, 3);
                shipConfig.put(3, 2);
                shipConfig.put(4, 1);
                break;
            case 15:
                shipConfig.put(1, 5);
                shipConfig.put(2, 4);
                shipConfig.put(3, 3);
                shipConfig.put(4, 2);
                shipConfig.put(5, 1);
                break;
            case 21:
                shipConfig.put(1, 6);
                shipConfig.put(2, 5);
                shipConfig.put(3, 4);
                shipConfig.put(4, 3);
                shipConfig.put(5, 2);
                shipConfig.put(6, 1);;
                break;
            default:
                shipConfig.put(1, 4);
                shipConfig.put(2, 3);
                shipConfig.put(3, 2);
                shipConfig.put(4, 1);
                break;
            }
    }

}
