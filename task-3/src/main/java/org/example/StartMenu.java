package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.util.Objects;
import java.util.Scanner;

public class StartMenu extends JFrame {
    private JPanel buttonsPanel;
    private RulesPanel rulesPanel;

    private JPanel cardPanel;
    private CardLayout menuCardLayout;


    public StartMenu() {
        super("Sea Battle");
        setSize(1366, 768);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        ImageIcon icon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/Icon.png")));
        setIconImage(icon.getImage());
        setLayout(new BorderLayout());
    }

    public void init() {
//        Font mainComicSans = new Font("Comic Sans MS", Font.BOLD, 40);
//        Color mainBlue = new Color(17, 65, 168);

        createLogoPanel();
        createButtonsPanel();

        menuCardLayout = new CardLayout();
        cardPanel = new JPanel(menuCardLayout);
        cardPanel.add(buttonsPanel, "Buttons");
        this.add(cardPanel);

        setVisible(true);
    }

    private void createLogoPanel() {
        JPanel logoPanel = new JPanel();
        JLabel logo = new JLabel("Sea Battle");
        logo.setFont(new Font("Comic Sans MS", Font.BOLD, 96));
        logo.setForeground(Color.WHITE);
        logoPanel.add(logo);
        logoPanel.setBackground(new Color(17, 65, 168));
        logoPanel.setPreferredSize(new Dimension(1366, 150));
        this.add(logoPanel, BorderLayout.NORTH);
    }

    private void createButtonsPanel() {
        buttonsPanel = new JPanel(new GridBagLayout());

        JButton startButton = createButton("Start Game");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Game game = new Game();
//                GameFrame gameFrame = new GameFrame();

//                JFrame gameMenu = new JFrame("Here will be the game window soon...");
//                gameMenu.setSize(1366, 768);
//
//                JLabel message = new JLabel("Game will be soon...");
//                message.setFont(new Font("Comic Sans MS", Font.BOLD, 96));
//                gameMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                gameMenu.add(message);
//                gameMenu.setVisible(true);
            }
        });
        buttonsPanel.add(startButton, new GridBagConstraints(0, 0, 6, 1, 0.0, 0.9, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(75, 1, 1, 1), 0, 0));


        JButton rulesButton = createButton("Rules");
        rulesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rulesPanel = new RulesPanel();
                rulesPanel.init();
                cardPanel.add(rulesPanel, "Rules");
                menuCardLayout.show(cardPanel, "Rules");
            }
        });
        buttonsPanel.add(rulesButton, new GridBagConstraints(0, 1, 6, 1, 0.0, 0.9, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));

        JButton exitButton = createButton("Exit");
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        buttonsPanel.add(exitButton, new GridBagConstraints(0, 2, 6, 1, 0.0, 0.9, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));

        buttonsPanel.setBackground(new Color(179, 255, 255));
    }

    private class RulesPanel extends JPanel {
        public RulesPanel() {
            super(new GridBagLayout());
            this.setBackground(new Color(179, 255, 255));
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

            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    menuCardLayout.show(cardPanel, "Buttons");
                }
            });
            this.add(button, new GridBagConstraints(0, 20, 1, 1, 0.0, 0.9, GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL, new Insets(0, 1, 1, 1), 0, 0));

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

    private JButton createButton(String buttonName) {
        JButton button = new JButton(buttonName);
        button.setFont(new Font("Comic Sans MS", Font.BOLD, 64));
        button.setBackground(new Color(17, 65, 168));
        button.setForeground(Color.WHITE);
        return button;
    }
}