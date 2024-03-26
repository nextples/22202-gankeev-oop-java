package org.example.view.game;

import org.example.model.Field;
import org.example.service.Observer;

import javax.swing.*;
import java.awt.*;

public abstract class FieldPanel extends JPanel implements Observer {
    private Field field;

    public FieldPanel(Field field) {

        this.field = field;
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int panelWidth = this.getSize().width;
        int panelHeight = this.getSize().height;

        int fieldSize = field.getFieldSize();
        int cellSize = (panelWidth - 1) / fieldSize;

        for (int i = 0; i < fieldSize + 1; i++) {
            g.drawLine(0, i * cellSize, cellSize * fieldSize, i * cellSize);
            g.drawLine(i * cellSize, 0, i * cellSize, cellSize * fieldSize);
        }

        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                int cellStatus = field.getCells()[i][j].getStatus();
                g.setColor(this.getColorByCellStatus(cellStatus));
                g.fillRect(i * cellSize + 1, j * cellSize + 1, cellSize - 1, cellSize - 1);
            }
        }
    }

    abstract protected Color getColorByCellStatus(int status);

//    @Override
//    public void update() {
//        this.repaint();
//    }

}
