package org.example.model;

import java.util.ArrayList;

public class Ship {
    public final static int SHIP_HORIZONTAL = 1;
    public final static int SHIP_VERTICAL = 2;

    public final static int SHIP_WELL = 3;
    public final static int SHIP_INJURED = 4;
    public final static int SHIP_KILLED = 5;
    public final static int SHIP_MISSED = 6;

//    private int fieldSize;
//    private Cell[][] cells;

    private int x;
    private int y;
    private int size;
    private int health;
    private int status;

    private ArrayList<Cell> shipCells;
    private ArrayList<Cell> borderCells;

    public Ship(int size) {
        this.size = size;
        this.health = size;
        this.status = SHIP_WELL;
    }

//    public boolean setShip(int x, int y, int orientation) {
//        for (int i = 0; i < size; i++) {
//            if (orientation == SHIP_HORIZONTAL) {
//                if ( (x + size <= fieldSize) && (!cells[x + i][y + j].containShip()) && (!cells[x + i][y + j].containShip()) ) {
//                    cells[x + i][y + j].setShip();
//                }
//            }
//        }
//
//
//        int dx = 0;
//        int dy = 0;
//        if (orientation == SHIP_HORIZONTAL) {
//            dx = 1;
//            dy = 0;
//        }
//        if (orientation == SHIP_VERTICAL) {
//            dx = 0;
//            dy = 1;
//        }
//
//        for (int i = 0; i < size * dx; i++) {       // iteration by x-coordinate
//            for (int j = 0; j < size * dy; j++) {   // iteration by y-coordinate
//
//                if ( (x + size < fieldSize) && (y + size < fieldSize) && (!cells[x + i][y + j].containShip()) && (!cells[x + i][y + j].containShip()) ) {
//                       cells[x + i][y + j].setShip();
//                }
//                else {
//                    return false;
//                }
//            }
//        }
//        return true;
//    }


    public int getSize() {
        return size;
    }

    public void addShipCell(Cell cell) {
        shipCells.add(cell);
    }

    public void addBorderCell(Cell cell) {
        borderCells.add(cell);
    }

}
