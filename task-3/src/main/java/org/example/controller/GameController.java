package org.example.controller;

import org.example.model.GameModel;
import org.example.service.Observable;
import org.example.view.game.GameView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameController extends Observable implements ActionListener, KeyListener {
    private final GameModel model;
    private final GameView view;

    public GameController(GameView view, GameModel model) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        String textButton = arrangementBox.getButtonGroup().getSelection().getActionCommand();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
