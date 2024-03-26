package org.example.view.game;

import org.example.controller.ArrangementController;
import org.example.model.GameModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameView {
    private final GameModel model;

//    private final GameController gameController;
    private final ArrangementController arrangementController;

    private final GameFrame frame;
    private final ArrangementFieldPanel arrangementField;
    private final ArrangementBoxPanel arrangementBox;
    private boolean isArranged = false;

    public GameView(GameModel model) {
        frame = new GameFrame();
        this.model = model;
//        gameController = new GameController(this, model);

        arrangementBox = new ArrangementBoxPanel(model);
        arrangementField = new ArrangementFieldPanel(model, arrangementBox);
        arrangementField.setPreferredSize(new Dimension(500, 500));
        arrangementController = new ArrangementController(model, arrangementField, arrangementBox);
        arrangementField.addKeyListener(arrangementController);
        arrangementBox.init(arrangementController);


        frame.add(arrangementBox, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.9, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
        frame.add(arrangementField, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.9, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
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
