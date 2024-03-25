package org.example.view.menu;

import org.example.controller.MenuController;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class StartMenu extends JFrame {
    public static final int RULES_PANEL = 1;
    public static final int BUTTONS_PANEL = 2;

    private MenuController menuController;

    private ButtonsPanel buttonsPanel;
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

        menuController = new MenuController(this);
    }

    public void init() {
//        Font mainComicSans = new Font("Comic Sans MS", Font.BOLD, 40);
//        Color mainBlue = new Color(17, 65, 168);

        createLogoPanel();
        this.buttonsPanel = new ButtonsPanel(menuController);
        buttonsPanel.init();

        this.rulesPanel = new RulesPanel(menuController);
        rulesPanel.init();

        menuCardLayout = new CardLayout();
        cardPanel = new JPanel(menuCardLayout);
        cardPanel.add(buttonsPanel, "Buttons");
        cardPanel.add(rulesPanel, "Rules");
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

    public void switchCardPanel(int panel) {
        if (panel == RULES_PANEL) {
            menuCardLayout.show(cardPanel, "Rules");
        }
        if (panel == BUTTONS_PANEL) {
            menuCardLayout.show(cardPanel, "Buttons");
        }
    }

    public JComboBox<String> getModeSelector() {
        return buttonsPanel.getModeSelector();
    }



    public void close() {
        this.dispose();
    }
}