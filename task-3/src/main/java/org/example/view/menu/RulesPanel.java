package org.example.view.menu;

import org.example.controller.MenuController;

import javax.swing.*;
import java.awt.*;
import java.io.InputStream;
import java.util.Scanner;

public class RulesPanel extends JPanel {
    private final MenuController menuController;

    public RulesPanel(MenuController menuController) {
        super(new GridBagLayout());
        this.setBackground(new Color(179, 255, 255));
        this.menuController = menuController;
    }

    public void init() {
        createLogo();
        createBackButton();
        addRules();
    }

    private void createLogo() {
        JPanel logoPanel = new JPanel();
        JLabel logo = new JLabel("The Rules of the Game");
        logo.setFont(new Font("Comic Sans MS", Font.BOLD, 50));
        logo.setForeground(Color.WHITE);
        logoPanel.setBackground(new Color(17, 65, 168));
        logoPanel.add(logo);

        this.add(logoPanel, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.9, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 1, 1, 1), 0, 0));
    }

    private void createBackButton() {
        JButton button = new JButton("Back");
        button.setFont(new Font("Comic Sans MS", Font.BOLD, 32));
        button.setBackground(new Color(17, 65, 168));
        button.setForeground(Color.WHITE);
        button.addActionListener(menuController);

        this.add(button, new GridBagConstraints(0, 21, 1, 1, 0.0, 0.9, GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL, new Insets(0, 1, 1, 1), 0, 0));

    }

    private void addRules() {
        InputStream in = ClassLoader.getSystemClassLoader().getResourceAsStream("Rules.txt");
        Scanner scanner = new Scanner(in);
        String rule;
        int cnt = 0;
        while(scanner.hasNextLine()) {
            rule = scanner.nextLine();
            JLabel label = new JLabel(rule);
            label.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
            this.add(label, new GridBagConstraints(0, cnt + 1, 1, 1, 0.0, 0.9, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
            cnt++;
        }
    }
}
