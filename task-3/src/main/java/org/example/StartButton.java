package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartButton extends JButton {
    public StartButton() {
        super("Start Game");
        this.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
        this.setBackground(new Color(17, 65, 168));
        this.setForeground(Color.WHITE);
    }
}
