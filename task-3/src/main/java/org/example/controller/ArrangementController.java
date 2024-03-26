package org.example.controller;

import org.example.model.Field;
import org.example.view.game.ArrangementBoxPanel;
import org.example.view.game.ArrangementFieldPanel;

import javax.swing.*;
import javax.swing.event.AncestorListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Enumeration;

import static org.example.model.Ship.SHIP_HORIZONTAL;

public class ArrangementController implements ActionListener, KeyListener {
    private Field field;
    private ArrangementFieldPanel arrangementField;
    private ArrangementBoxPanel arrangementBox;


    public void setArrangementField(ArrangementFieldPanel arrangementField) {
        this.arrangementField = arrangementField;
    }

    public void setArrangementBox(ArrangementBoxPanel arrangementBox) {
        this.arrangementBox = arrangementBox;
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
//        Enumeration<JRadioButton> buttons =  (Enumeration<JRadioButton>) (arrangementBox.getButtonGroup().getElements());
//        String textButton = arrangementBox.getButtonGroup().getSelection().getActionCommand();
//        switch (textButton) {
//            case "1-ship":
//                arrangementField.printShip(0, 1, 1, SHIP_HORIZONTAL);
//                break;
//            case "2-ship":
//                arrangementField.printShip(0, 1, 2, SHIP_HORIZONTAL);
//                break;
//            case "3-ship":
//                arrangementField.printShip(0, 1, 3, SHIP_HORIZONTAL);
//                break;
//            case "4-ship":
//                arrangementField.printShip(0, 1, 4, SHIP_HORIZONTAL);
//                break;
//            case "5-ship":
//                arrangementField.printShip(0, 1, 5, SHIP_HORIZONTAL);
//                break;
//            case "6-ship":
//                arrangementField.printShip(0, 1, 6, SHIP_HORIZONTAL);
//                break;
//        }
    }
}
