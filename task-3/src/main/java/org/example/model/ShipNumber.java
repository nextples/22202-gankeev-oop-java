package org.example.model;

public class ShipNumber {
    private int currentNumber;
    private final int maxNumber;

    public ShipNumber(int currentNumber, int maxNumber) {
        this.currentNumber = currentNumber;
        this.maxNumber = maxNumber;
    }

    public int getCurrentNumber() {
        return currentNumber;
    }

    public int getMaxNumber() {
        return maxNumber;
    }

    public void setCurrentNumber(int currentNumber) {
        this.currentNumber = currentNumber;
    }
}
