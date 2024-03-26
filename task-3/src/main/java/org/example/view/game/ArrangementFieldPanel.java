package org.example.view.game;

import org.example.controller.ArrangementController;
import org.example.model.Field;
import org.example.service.Observer;

import javax.swing.*;
import java.awt.*;

import static org.example.model.Ship.SHIP_HORIZONTAL;
import static org.example.model.Ship.SHIP_VERTICAL;

public class ArrangementFieldPanel extends JPanel implements Observer {
    private final ArrangementBoxPanel arrangementBox;

    private Field field;
    private final ArrangementController controller;


    public ArrangementFieldPanel(Field field, ArrangementBoxPanel arrangementBox) {
        this.field = field;
        this.arrangementBox = arrangementBox;
        this.controller = new ArrangementController();

        this.addKeyListener(controller);

    }

    protected int getCellSize() {
        return (this.getSize().width - 1) / field.getFieldSize();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int fieldSize = field.getFieldSize();
        int cellSize = getCellSize();

        for (int i = 0; i < fieldSize + 1; i++) {
            g.drawLine(0, i * cellSize, cellSize * fieldSize, i * cellSize);
            g.drawLine(i * cellSize, 0, i * cellSize, cellSize * fieldSize);
        }

        for (int x = 0; x < fieldSize; x++) {
            for (int y = 0; y < fieldSize; y++) {

            }
        }

    }

    public void printShip(int x, int y, int size, int orientation) {
        controller.setArrangementField(this);
        Graphics g = this.getGraphics();
        int fieldSize = field.getFieldSize();
        int cellSize = getCellSize();
//
//        if (orientation == SHIP_HORIZONTAL) {
//            for (int i = 0; i < size; i++) {
//                g.setColor(Color.BLACK);
//                g.fillRect((x + i) * cellSize + 1, (y + i) * cellSize + 1, cellSize - 1, cellSize - 1);
//            }
//        }

        for (int i = 0; i < size; i++) {
            if (orientation == SHIP_HORIZONTAL) {
                g.setColor(Color.CYAN);
                g.fillRect((x + i) * cellSize + 1, y * cellSize + 1, cellSize - 1, cellSize - 1);
            }
            if (orientation == SHIP_VERTICAL) {
                g.setColor(Color.CYAN);
                g.fillRect(x * cellSize + 1, (y + i) * (cellSize) + 1, cellSize - 1, cellSize - 1);
            }
//            g.setColor(Color.CYAN);
//            g.fillRect((x + i) * cellSize + 1, y * cellSize + 1, cellSize - 1, cellSize - 1);
//
//            g.setColor(Color.CYAN);
//            g.fillRect(x * cellSize + 1, (y + i) * (cellSize) + 1, cellSize - 1, cellSize - 1);

        }
    }

    private void print() {
        String textButton = arrangementBox.getButtonGroup().getSelection().getActionCommand();
        switch (textButton) {
            case "1-ship":
                this.printShip(0, 1, 1, SHIP_HORIZONTAL);
                break;
            case "2-ship":
                this.printShip(0, 1, 2, SHIP_HORIZONTAL);
                break;
            case "3-ship":
                this.printShip(0, 1, 3, SHIP_HORIZONTAL);
                break;
            case "4-ship":
                this.printShip(0, 1, 4, SHIP_HORIZONTAL);
                break;
            case "5-ship":
                this.printShip(0, 1, 5, SHIP_HORIZONTAL);
                break;
            case "6-ship":
                this.printShip(0, 1, 6, SHIP_HORIZONTAL);
                break;
        }
    }

    @Override
    public void update() {
        repaint();
    }
}
