package org.example.controller;

import org.example.model.GameModel;
import org.example.view.game.GameView;
import org.example.view.menu.StartMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuController implements ActionListener {
    private final StartMenu menu;

    public MenuController(StartMenu menu) {
        this.menu = menu;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        switch (cmd) {
            case "Exit":
                System.exit(0);
                break;

            case "Rules":
                menu.switchCardPanel(StartMenu.RULES_PANEL);
                break;

            case "Back":
                menu.switchCardPanel(StartMenu.BUTTONS_PANEL);
                break;

            case "Start Game":
                menu.dispose();
                GameModel gameModel = new GameModel(10);
                GameView gameView = new GameView(gameModel);
                break;
        }
    }
}
