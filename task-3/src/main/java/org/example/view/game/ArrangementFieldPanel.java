package org.example.view.game;

import org.example.model.Field;

import javax.swing.*;
import java.awt.*;

public class ArrangementFieldPanel extends JPanel {
    private Field field;

    public ArrangementFieldPanel(Field field) {
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
    }

}
