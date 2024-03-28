package org.example.view.game;

import org.example.controller.ArrangementController;
import org.example.event.ArrangementEvent;
import org.example.model.Field;
import org.example.model.GameModel;
import org.example.service.Observer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static org.example.model.Ship.SHIP_HORIZONTAL;
import static org.example.model.Ship.SHIP_VERTICAL;

public class ArrangementFieldPanel extends JPanel implements Observer {
    private GameModel model;


    public ArrangementFieldPanel(GameModel model, ArrangementBoxPanel arrangementBox) {
        this.model = model;
    }

    protected int getCellSize() {
        return (this.getSize().width - 1) / model.getPlayerField().getFieldSize();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int fieldSize = model.getPlayerField().getFieldSize();
        int cellSize = getCellSize();

        for (int i = 0; i < fieldSize + 1; i++) {
            g.drawLine(0, i * cellSize, cellSize * fieldSize, i * cellSize);
            g.drawLine(i * cellSize, 0, i * cellSize, cellSize * fieldSize);
        }

        for (int x = 0; x < fieldSize; x++) {
            for (int y = 0; y < fieldSize; y++) {
                if (model.getPlayerField().getCells()[x][y].containShip()) {
                    g.setColor(Color.GRAY);
                    g.fillRect(x * cellSize + 1, y * cellSize + 1, cellSize - 1, cellSize - 1);
                }

                if (model.getPlayerField().getCells()[x][y].isPicked()) {
                    if (model.getPlayerField().getCells()[x][y].isBorder() || model.getPlayerField().getCells()[x][y].containShip()) {
                        g.setColor(Color.RED);
                        g.fillRect(x * cellSize + 1, y * cellSize + 1, cellSize - 1, cellSize - 1);
                    }
                    else {
                        g.setColor(Color.CYAN);
                        g.fillRect(x * cellSize + 1, y * cellSize + 1, cellSize - 1, cellSize - 1);
                    }

                }

            }
        }
    }

    @Override
    public void update(org.example.event.Event event) {
        if (event instanceof ArrangementEvent) {
            repaint();
        }
    }
}
