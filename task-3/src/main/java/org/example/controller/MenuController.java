package org.example.controller;

import org.example.model.GameModel;
import org.example.view.game.GameView;
import org.example.view.menu.StartMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuController implements ActionListener {
    private final StartMenu menu;
    private int fieldSize;

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
                String mode = (String) menu.getModeSelector().getSelectedItem();
                switch (mode) {
                    case "10 x 10":
                    case null:
                        fieldSize = 10;
                        break;

                    case "15 x 15":
                        fieldSize = 15;
                        break;

                    case "21 x 21":
                        fieldSize = 21;
                        break;

                        default:
                        fieldSize = 10;
                        break;
                }
                menu.dispose();
                GameModel gameModel = new GameModel(fieldSize);
                GameView gameView = new GameView(gameModel);
                GameController gameController = new GameController(gameView, gameModel);
                break;

        }
    }
}
