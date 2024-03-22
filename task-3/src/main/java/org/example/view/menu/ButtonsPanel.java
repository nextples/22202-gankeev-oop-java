package org.example.view.menu;

import org.example.controller.MenuController;

import javax.swing.*;
import java.awt.*;

public class ButtonsPanel extends JPanel {
    private final MenuController menuController;

    public ButtonsPanel(MenuController menuController) {
        super(new GridBagLayout());
        this.menuController = menuController;
    }

    public void init() {
        JButton startButton = createButton("Start Game");
        startButton.addActionListener(menuController);
//        startButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                dispose();
//                GameModel gameModel = new GameModel(10);
//                GameView gameView = new GameView(gameModel);
//            }
//        });
        this.add(startButton, new GridBagConstraints(0, 0, 6, 1, 0.0, 0.9, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(75, 1, 1, 1), 0, 0));

        JButton rulesButton = createButton("Rules");
        rulesButton.addActionListener(menuController);
//        rulesButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                rulesPanel = new RulesPanel();
//                rulesPanel.init();
//                cardPanel.add(rulesPanel, "Rules");
//                menuCardLayout.show(cardPanel, "Rules");
//            }
//        });
        this.add(rulesButton, new GridBagConstraints(0, 1, 6, 1, 0.0, 0.9, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));

        JButton exitButton = createButton("Exit");
        exitButton.addActionListener(menuController);
//        exitButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                System.exit(0);
//            }
//        });
        this.add(exitButton, new GridBagConstraints(0, 2, 6, 1, 0.0, 0.9, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));

        this.setBackground(new Color(179, 255, 255));
    }

    private JButton createButton(String buttonName) {
        JButton button = new JButton(buttonName);
        button.setFont(new Font("Comic Sans MS", Font.BOLD, 64));
        button.setBackground(new Color(17, 65, 168));
        button.setForeground(Color.WHITE);
        return button;
    }
}
