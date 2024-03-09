package org.example;

import javax.swing.*;
import java.awt.*;

public class ExitButton extends JButton {
    public ExitButton() {
        super("Exit");
        this.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
        this.setBackground(new Color(17, 65, 168));
        this.setForeground(Color.WHITE);

//        buttonsPanel.add(this, new GridBagConstraints(0, 2, 6, 1, 0.0, 0.9, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));

        this.addActionListener(new ExitButtonActionListener());

    }
}
