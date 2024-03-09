package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class StartMenu extends JFrame {
    public StartMenu() {
        super("Sea Battle");
        setSize(1366, 768);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        ImageIcon icon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/Icon.png")));
        setIconImage(icon.getImage());

        setLayout(new BorderLayout());

        Font mainComicSans = new Font("Comic Sans MS", Font.BOLD, 40);
        Color mainBlue = new Color(17, 65, 168);

        JPanel logoPanel = new JPanel();
        JLabel logo = new JLabel("Sea Battle");
        logo.setFont(new Font("Comic Sans MS", Font.BOLD, 96));
        logo.setForeground(Color.WHITE);
        logoPanel.add(logo);
        logoPanel.setBackground(new Color(17, 65, 168));
        logoPanel.setPreferredSize(new Dimension(1366, 256));
        this.add(logoPanel, BorderLayout.NORTH);

        JPanel buttonsPanel = new JPanel(new GridBagLayout());

        JButton startButton = new StartButton();
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();

                JFrame gameMenu = new JFrame("Here will be the game window soon...");
                gameMenu.setSize(1366, 768);
                JLabel message = new JLabel("Here will be the game window soon...");
                gameMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                gameMenu.add(message);
                gameMenu.setVisible(true);
            }
        });
        buttonsPanel.add(startButton, new GridBagConstraints(0, 0, 6, 1, 0.0, 0.9, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(75, 1, 1, 1), 0, 0));

        JButton rulesButton = new RulesButton();
        buttonsPanel.add(rulesButton, new GridBagConstraints(0, 1, 6, 1, 0.0, 0.9, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));

        JButton exitButton = new ExitButton();
        buttonsPanel.add(exitButton, new GridBagConstraints(0, 2, 6, 1, 0.0, 0.9, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));

        buttonsPanel.setBackground(new Color(179, 255, 255));
        add(buttonsPanel, BorderLayout.CENTER);
        setVisible(true);
    }
}
