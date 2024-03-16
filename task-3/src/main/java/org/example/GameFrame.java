package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class GameFrame extends JFrame {

    public GameFrame() {
        super("Sea Battle");
        this.setSize(1366, 768);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        ImageIcon icon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/Icon.png")));
        setIconImage(icon.getImage());
        this.setLayout(new GridBagLayout());

//        JButton continueButton = createButton("Continue");
//        JPanel bottomPanel = new JPanel(new BorderLayout());
//        bottomPanel.add(continueButton, BorderLayout.EAST);
//        bottomPanel.setBackground(new Color(17, 65, 168));
//        bottomPanel.setPreferredSize(new Dimension(1534, 96));
//        this.add(bottomPanel, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.9, GridBagConstraints.SOUTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1/*1330*/, 1, 1), 0, 0));

        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
//        this.setVisible(true);
    }

    private JButton createButton(String buttonName) {
        JButton button = new JButton(buttonName);
        button.setFont(new Font("Comic Sans MS", Font.BOLD, 48));
        button.setBackground(new Color(17, 65, 168));
        button.setForeground(Color.WHITE);
        return button;
    }
}
