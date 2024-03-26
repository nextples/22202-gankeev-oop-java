package org.example.controller;

import org.example.event.ArrangementEvent;
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

import static org.example.model.Ship.SHIP_HORIZONTAL;

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


    @Override
    public void keyTyped(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_RIGHT:

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
    }
}
