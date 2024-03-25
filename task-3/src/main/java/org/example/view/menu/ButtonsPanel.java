package org.example.view.menu;

import org.example.controller.MenuController;

import javax.swing.*;
import java.awt.*;

public class ButtonsPanel extends JPanel {
    private final MenuController menuController;

    private JComboBox<String> gameMode;

    public ButtonsPanel(MenuController menuController) {
        super(new GridBagLayout());
        this.menuController = menuController;
    }

    public void init() {
        String[] fieldSizes = {"10 x 10", "15 x 15", "21 x 21"};
//        JButton[] fieldSizes = createFieldSizesArray();

        gameMode = new JComboBox<>(fieldSizes);
        gameMode.setFont(new Font("Comic Sans MS", Font.BOLD, 32));
        gameMode.setBackground(new Color(17, 65, 168));
        gameMode.setForeground(Color.WHITE);
        gameMode.addActionListener(menuController);
        this.add(gameMode, new GridBagConstraints(0, 1, 6, 1, 0.0, 0.9, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(0, 1, 1, 1), 0, 0));

        JButton startButton = createButton("Start Game");
        startButton.addActionListener(menuController);
        this.add(startButton, new GridBagConstraints(0, 0, 6, 1, 0.0, 0.9, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(75, 1, 0, 1), 0, 0));

        JButton rulesButton = createButton("Rules");
        rulesButton.addActionListener(menuController);
        this.add(rulesButton, new GridBagConstraints(0, 2, 6, 1, 0.0, 0.9, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));

        JButton exitButton = createButton("Exit");
        exitButton.addActionListener(menuController);
        this.add(exitButton, new GridBagConstraints(0, 3, 6, 1, 0.0, 0.9, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));

        this.setBackground(new Color(179, 255, 255));
    }

    private JButton[] createFieldSizesArray() {
        JButton[] gameModes = new JButton[3];
        gameModes[0] = new JButton("10 x 10");
        gameModes[1] = new JButton("15 x 15");
        gameModes[2] = new JButton("21 x 21");
        return gameModes;
    }

    private JButton createButton(String buttonName) {
        JButton button = new JButton(buttonName);
        button.setFont(new Font("Comic Sans MS", Font.BOLD, 64));
        button.setBackground(new Color(17, 65, 168));
        button.setForeground(Color.WHITE);
        return button;
    }

    public JComboBox<String> getModeSelector() {
        return gameMode;
    }
}
