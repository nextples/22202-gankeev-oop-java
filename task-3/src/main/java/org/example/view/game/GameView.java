package org.example.view.game;

import org.example.controller.ArrangementController;
import org.example.model.GameModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameView {
    private final GameModel model;

    private final ArrangementController arrangementController;

    private final GameFrame frame;
    private final ArrangementFieldPanel arrangementField;
    private final ArrangementBoxPanel arrangementBoxPanel;
    private boolean isArranged = false;

    public GameView(GameModel model) {
        frame = new GameFrame();
        this.model = model;

        arrangementController = new ArrangementController();
        arrangementBoxPanel = new ArrangementBoxPanel(model.getPlayerField());
        arrangementField = new ArrangementFieldPanel(model.getPlayerField(), arrangementBoxPanel);

        arrangementField.setPreferredSize(new Dimension(500, 500));

        frame.add(arrangementBoxPanel, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.9, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
        frame.add(arrangementField, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.9, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));

//        this.init();


        frame.setVisible(true);
    }

    private void init() {
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
