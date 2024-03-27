package org.example.controller;

import org.example.event.ArrangementEvent;
import org.example.model.Cell;
import org.example.model.Field;
import org.example.model.GameModel;
import org.example.service.Observable;
import org.example.view.game.ArrangementBoxPanel;
import org.example.view.game.ArrangementFieldPanel;

import javax.swing.*;
import javax.swing.event.AncestorListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static java.lang.Math.abs;
import static org.example.model.Ship.SHIP_HORIZONTAL;
import static org.example.model.Ship.SHIP_VERTICAL;

public class ArrangementController extends Observable implements ActionListener, KeyListener {
    private GameModel model;
    private ArrangementFieldPanel arrangementField;
    private ArrangementBoxPanel arrangementBox;

    public ArrangementController(GameModel model, ArrangementFieldPanel arrangementField, ArrangementBoxPanel arrangementBox) {
        this.model = model;
        this.arrangementBox = arrangementBox;
        this.arrangementField = arrangementField;
        this.addObserver(arrangementField);
    }

    private int countSize() {
        Field field = model.getPlayerField();
        int cnt = 0;
        for (int x = 0; x < field.getFieldSize(); x++) {
            for (int y = 0; y < field.getFieldSize(); y++) {
                if (field.getCells()[y][x].isPicked()) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private int determineOrientation(Cell cell) {
        Field field = model.getPlayerField();
        int size = field.getFieldSize();
        int x = cell.getX();
        int y = cell.getY();
        if ( (x + 1 < size && field.getCells()[x + 1][y].isPicked()) || (x - 1 >= 0 && field.getCells()[x - 1][y].isPicked()) ) {
            return SHIP_HORIZONTAL;
        }
        return SHIP_VERTICAL;
    }

    private void moveRight(int x, int y) {
        Field field = model.getPlayerField();
        int shipSize = countSize();
        if (determineOrientation(field.getCells()[x][y]) == SHIP_HORIZONTAL) {
            if (x + shipSize + 1 >= field.getFieldSize()) {
                return;
            }
            field.getCells()[x][y].setPicked(false);
            field.getCells()[x + shipSize][y].setPicked(true);
        }
        else {
            if (x + 1 >= field.getFieldSize()) {
                return;
            }
            for (int i = 0; i < shipSize; i++) {
                field.getCells()[x][y + i].setPicked(false);
                field.getCells()[x + 1][y + i].setPicked(true);
            }
        }
    }

    private void moveLeft(int x, int y) {
        if (x - 1 < 0) {
            return;
        }

        Field field = model.getPlayerField();
        int shipSize = countSize();
        if (determineOrientation(field.getCells()[x][y]) == SHIP_HORIZONTAL) {
            field.getCells()[x + shipSize - 1][y].setPicked(false);
            field.getCells()[x - 1][y].setPicked(true);
        }
        else {
            for (int i = 0; i < shipSize; i++) {
                field.getCells()[x][y + i].setPicked(false);
                field.getCells()[x - 1][y + i].setPicked(true);
            }
        }
    }

    private void moveUp(int x, int y) {
        if (y - 1 < 0) {
            return;
        }
        Field field = model.getPlayerField();
        int shipSize = countSize();
        if (determineOrientation(field.getCells()[x][y]) == SHIP_HORIZONTAL) {
            for (int i = 0; i < shipSize; i++) {
                field.getCells()[x][y - 1].setPicked(false);
                field.getCells()[x + i][y - 1].setPicked(true);
            }
        }
        else {
            field.getCells()[x][y + shipSize - 1].setPicked(false);
            field.getCells()[x][y - 1].setPicked(true);
        }
    }

    private void moveDown(int x, int y) {
        Field field = model.getPlayerField();
        int shipSize = countSize();
        if (determineOrientation(field.getCells()[x][y]) == SHIP_HORIZONTAL) {
            if (y + 1 >= field.getFieldSize()) {
                return;
            }
            for (int i = 0; i < shipSize; i++) {
                field.getCells()[x + i][y].setPicked(false);
                field.getCells()[x + i][y + 1].setPicked(true);
            }
        }
        else {
            if (y + shipSize >= field.getFieldSize()) {
                return;
            }
            field.getCells()[x][y].setPicked(false);
            field.getCells()[x][y + shipSize].setPicked(true);
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {
        Field field = model.getPlayerField();
        char keyChar = e.getKeyChar();

        for (int x = 0; x < field.getFieldSize(); x++) {
            for (int y = 0; y < field.getFieldSize(); y++) {    // find first picked cell
                if (field.getCells()[x][y].isPicked()) {

                    if (keyChar == 'D' || keyChar == 'd' || keyChar == 'в' || keyChar == 'В') {
                        moveRight(x, y);
                        arrangementField.update(new ArrangementEvent());
                        return;
                    }

                    if (keyChar == 'A' || keyChar == 'a' || keyChar == 'ф' || keyChar == 'Ф') {
                        moveLeft(x, y);
                        arrangementField.update(new ArrangementEvent());
                        return;
                    }

                    if (keyChar == 'W' || keyChar == 'w' || keyChar == 'ц' || keyChar == 'Ц') {
                        moveUp(x, y);
                        arrangementField.update(new ArrangementEvent());
                        return;
                    }

                    if (keyChar == 'S' || keyChar == 's' || keyChar == 'ы' || keyChar == 'Ы') {
                        moveDown(x, y);
                        arrangementField.update(new ArrangementEvent());
                        return;
                    }
                }
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String textButton = arrangementBox.getButtonGroup().getSelection().getActionCommand();
        Field field = model.getPlayerField();

        if (textButton != null) {
            field.clearPickedCells();
            int size = Integer.parseInt(String.valueOf(textButton.charAt(0)));
            for (int i = 0; i < size; i++) {
                field.getCells()[0][i].setPicked(true);
            }
            arrangementField.update(new ArrangementEvent());
        }
        arrangementField.requestFocusInWindow();
    }
}
