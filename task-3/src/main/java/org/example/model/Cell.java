package org.example.model;

public class Cell {
    public final static int CELL_WATER = 1;
    public final static int CELL_BORDER = 2;
    public final static int CELL_WELL = 3;
    public final static int CELL_INJURED = 4;
    public final static int CELL_KILLED = 5;
    public final static int CELL_MISSED = 6;

//    public final static int CELL_PICKED = 7;

    private int x;
    private int y;
    private int status;
    private Ship ship;

    /**
     * 1 if the cell was checked with a random arrangement of ships
     */
    private boolean randomlyChecked;

    /**
     * 1 if a ship was installed on the cell
     */
    private boolean containShip;

    /**
     * 1 if a shot was fired at the cell
     */
    private boolean wasShot;

    /**
     * 1 if the cell is the border of the ship
     */
    private boolean isBorder;

    private boolean isPicked;


    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
        status = CELL_WATER;
        containShip = false;
        wasShot = false;
        isBorder = false;
        randomlyChecked = false;
        isPicked = false;
    }

    public void setShip() {
        containShip = true;
    }

    public void shot() {
        wasShot = true;
    }

    public boolean containShip() {
        return containShip;
    }

    public boolean isPicked() {
        return isPicked;
    }

    public void setPicked(boolean picked) {
        isPicked = picked;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isShot() {
        return wasShot;
    }

    public boolean isRandomlyChecked() {
        return randomlyChecked;
    }

    public void setRandomlyChecked(boolean randomlyChecked) {
        this.randomlyChecked = randomlyChecked;
    }

    public int getStatus() {
        return status;
    }

//    public void setStatus(int status) {
//        this.status = status;
//    }
}
