package org.example.event;

public class SettingArrangementEvent extends ArrangementEvent {
    private final int shipSize;
    public SettingArrangementEvent(int shipSize) {
        this.shipSize = shipSize;
    }

    public int getShipSize() {
        return shipSize;
    }
}
