package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game {
    private final JFrame frame;
    private JPanel shipArrangement;
    private boolean isArranged = false;

    public Game() {
        frame = new GameFrame();

        JButton continueButton = createButton("Continue");
        continueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isArranged) {
                    JPanel dialogPanel = new JPanel();
                    JOptionPane.showMessageDialog(dialogPanel, "Ships are not arranged yet", "Warning", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(continueButton, BorderLayout.EAST);
        bottomPanel.setBackground(new Color(17, 65, 168));
        bottomPanel.setPreferredSize(new Dimension(1534, 96));
        frame.add(bottomPanel, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.9, GridBagConstraints.SOUTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1/*1330*/, 1, 1), 0, 0));

        frame.setVisible(true);
    }

    private JButton createButton(String buttonName) {
        JButton button = new JButton(buttonName);
        button.setFont(new Font("Comic Sans MS", Font.BOLD, 48));
        button.setBackground(new Color(17, 65, 168));
        button.setForeground(Color.WHITE);
        return button;
    }
}
