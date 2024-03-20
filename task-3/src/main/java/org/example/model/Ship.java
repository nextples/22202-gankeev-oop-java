package org.example.model;

import java.util.ArrayList;

public class Ship {
    public final static int SHIP_HORIZONTAL = 1;
    public final static int SHIP_VERTICAL = 2;

    public final static int SHIP_WELL = 3;
    public final static int SHIP_INJURED = 4;
    public final static int SHIP_KILLED = 5;
    public final static int SHIP_MISSED = 6;

    private int fieldSize;
    private Cell[][] cells;

    private int x;
    private int y;
    private int size;
    private int health;
    private int status;

    private ArrayList<Cell> listCells;
    private ArrayList<Cell> listBorders;

    public Ship(int size) {
        this.size = size;
        this.health = size;
        this.status = SHIP_WELL;
    }

    /**
     * @param x X-coordinate of the upper left side of the ship
     * @param y Y-coordinate of the upper left side of the ship
     * @param orientation Vertical or Horizontal orientation of the ship on the field
     *
     * @return returns 1 if ship was successfully set to the place, returns 0 if the installation of the ship in the specified location is unacceptable
     */
    public boolean setShip(int x, int y, int orientation) {
        int dx = 0;
        int dy = 0;
        if (orientation == SHIP_HORIZONTAL) {
            dx = 1;
            dy = 0;
        }
        if (orientation == SHIP_VERTICAL) {
            dx = 0;
            dy = 1;
        }

        for (int i = 0; i < size * dx; i++) {       // iteration by x-coordinate
            for (int j = 0; j < size * dy; j++) {   // iteration by y-coordinate

                if ( (x + size < fieldSize) && (y + size < fieldSize) && (!cells[x + i][y + j].containShip()) && (!cells[x + i][y + j].containShip()) ) {
                       cells[x + i][y + j].setShip();
                }
                else {
                    return false;
                }
            }
        }
        return true;
    }

    public void setCells(Cell[][] cells) {
        this.cells = cells;
    }

    public void setFieldSize(int fieldSize) {
        this.fieldSize = fieldSize;
    }
}
